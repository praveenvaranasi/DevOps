set +x
key="/home/ec2-user/Learn/Keys/Praveen-AWS.pem"

cleanup()
{
	rm -f ~/temp/agent.jar ~/temp/jenkins-cli.jar
}

mail_the_Instancedetails()
{	
	#echo "*******************************************************************"
	#echo -e "******************************************************************* \n \n"
	#cat $1
	#echo -e "\n\n*******************************************************************"
	#echo "*******************************************************************"	
	python2.7 /home/ec2-user/Learn/Work/devops-cloud-automation/Python/mail_the_Instancedetails.py $1 $2
	echo -e "\nMailed the Details to $2 \n" 
}    

download_jars()
{
	echo -e "waiting for the Jenkins server to bootup\n"
	sleep 30s
	public_ip=$(cat $1 | grep -i "public_ip" | cut -d ' ' -f2)
	echo "Downloading the required Jars"	
    cd /home/ec2-user/temp
    wget http://${public_ip}:8080/jnlpJars/jenkins-cli.jar
    wget http://${public_ip}:8080/jnlpJars/agent.jar
	echo -e "Downloaded the Jars\n"
}

create_docker_network()
{
	ssh -o StrictHostKeyChecking=no -i ${key} centos@${public_ip} "\
    sudo docker network create dockerenv --subnet=192.168.1.0/28 "
    echo -e "\nCreated docker network\n"
}

configure_master()
{
	master_ip="192.168.1.2"
	master_id=$(ssh -o StrictHostKeyChecking=no -i ${key} centos@${public_ip} "sudo docker ps -aqf 'ancestor=praveenvp/softwares:jenkins'")	
    ssh -o StrictHostKeyChecking=no -i ${key} centos@${public_ip} "\
    sudo docker exec ${master_id} mkdir /root/.ssh && \
    sudo docker exec ${master_id} ssh-keygen -t rsa -f /root/.ssh/id_rsa -q -N '' && \
    sudo docker exec ${master_id} cp /root/.ssh/id_rsa.pub /root/authorized_keys && \
    sudo docker cp ${master_id}:/root/authorized_keys /home/centos && \
    sudo docker network connect dockerenv ${master_id} --ip ${master_ip}" 
    echo -e "Configured Jenkins_master container\n"
}

configure_node()
{	
	node_ip="192.168.1.3"
    scp -o StrictHostKeyChecking=no -i ${key} ~/temp/agent.jar centos@${public_ip}:/home/centos
	node_id=$(ssh -o StrictHostKeyChecking=no -i ${key} centos@${public_ip} "sudo docker ps -aqf 'ancestor=praveenvp/softwares:jenkins_slave'")
	ssh -o StrictHostKeyChecking=no -i ${key} centos@${public_ip} "\
	sudo docker network connect dockerenv ${node_id} --ip ${node_ip} && \
	sudo docker exec ${node_id} mkdir /root/.ssh /root/node && \
	sudo docker cp /home/centos/authorized_keys ${node_id}:/root/.ssh/ && \
    sudo docker cp /home/centos/agent.jar ${node_id}:/root/node && \
	sudo docker exec ${node_id} service sshd start"
    
	/usr/local/bin/python3.6 /home/ec2-user/Learn/Work/devops-cloud-automation/Python/node.py /home/ec2-user/temp/config.xml agentCommand ${node_ip}
	java -jar ~/temp/jenkins-cli.jar -s http://${public_ip}:8080/ -auth charterglobal:charterglobal create-node < ~/temp/config.xml
    echo -e "\nconfigured Jenkins_slave container \n"
	echo "Connect to the Jenkins server using ${public_ip}:8080"
}

cleanup
mail_the_Instancedetails ${output_file} ${Recipient_mail_ids}
download_jars ${output_file}
create_docker_network
configure_master
configure_node


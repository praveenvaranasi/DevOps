#! /bin/sh
working_dir=$(pwd)
temp_file=${working_dir}/temp.txt

usage()
{	
	echo -e "\n"
	cat <<EOF
	*******************************************************************************************
	The file contains the functions to start and stop the Instances using Tag and Value filters
	
	To start the Instances: 
			./AWS_Utilities.sh start_instances <Tag_Name> <Key_value>
			
	To Stop the Instances:
			./AWS_Utilities.sh stop_instances <Tag_Name> <Key_value>
	
	
	*******************************************************************************************
EOF
}

control_instances()
{
	
	if [ $# != '3' ]
	then
		usage
		exit
	fi

	fn_name=$1
	tag=$2
	tag_value=$3
	
	aws ec2 describe-instances --filters "Name=tag:${tag},Values=${tag_value}" --query 'Reservations[*].{InsIds: Instances[0].InstanceId}' --output text > ${temp_file}
	sed -i -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' ${temp_file}
	
	for i in `cat ${temp_file}`
	do
		echo ${i}
		${fn_name} $i ${tag} ${tag_value}
	done		
}

start_instances()
{
	echo "Starting the Instance with Instance-id ${i}"
	aws ec2 start-instances --instance-ids ${i}
	sleep 30s
	get_public_ip ${tag} ${tag_value}
}

stop_instances()
{
	echo "Stopping the Instance with Instance-id ${i}"
	aws ec2 stop-instances --instance-ids ${i}
}

get_public_ip()
{
	public_ip=$(aws ec2 describe-instances --filters "Name=tag:${tag},Values=${tag_value}" --query 'Reservations[*].{PubIP: Instances[0].PublicIpAddress}' --output text)
	echo "Connect to the Instance using the PublicIP: ${public_ip}"
}



control_instances $1 $2 $3
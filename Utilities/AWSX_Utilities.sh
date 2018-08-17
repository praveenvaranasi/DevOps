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
			
	To Check the Instance status:
			./AWS_Utilities.sh describe_instance_status <Tag_Name> <Key_value>
	
	To Check all Instance statuses:
			./AWSX_Utilities.sh describe-instance-status
	
	*******************************************************************************************
EOF
}

process_the_idfile()
{
	sed -i -e ':a' -e 'N' -e '$!ba' -e 's/\n/ /g' ${temp_file}
}

param_check()
{	
	[ $# -eq 3 ] && echo "Function related checks were done" || exit
}

get_public_ip()
{
	sleep 25s
	public_ip=$(aws ec2 describe-instances --filters "Name=tag:${tag},Values=${tag_value}" --query 'Reservations[*].{PubIP: Instances[0].PublicIpAddress}' --output text)
	echo "Connect to the Instance using the PublicIP: ${public_ip}"
}

get_the_instanceIds()
{
	aws ec2 describe-instances --filters "Name=tag:${tag},Values=${tag_value}" --query 'Reservations[*].{InsIds: Instances[0].InstanceId}' --output text > ${temp_file}
	process_the_idfile		
}

get_all_instanceids()
{
	aws ec2 describe-instances --query 'Reservations[*].{iid: Instances[*].InstanceId}' --output text | sed -e 's/[[:space:]]\+/ /g' | cut -d ' ' -f2 > ${temp_file}
	process_the_idfile	
}

main()
{	
	if [[ $1 == "start-instances" || $1 == "stop-instances" ]] ; then	
		
		param_check $@		
		fn_name=$1
		tag=$2
		tag_value=$3		
		get_the_instanceIds ${tag} ${tag_value}		
		for i in `cat ${temp_file}`
		do
			aws ec2 ${fn_name} --instance-ids ${i}
			[ $1 != "start-instances" ] &&  echo "" || get_public_ip ${tag} ${tag_value}
		done
		
	elif [ $1 == "describe-instance-status" ] ; then
	
		get_all_instanceids
		for i in `cat ${temp_file}`
		do
			echo -n `aws ec2 describe-tags --filters "Name=resource-id,Values=${i}" --query 'Tags[*].{Tag_value: Value}' --output text`": "
			aws ec2 describe-instance-status --include-all-instances --instance-ids ${i} --query 'InstanceStatuses[*].{state: InstanceState.Name}' --output text
		done		
		
	else		
		usage
	fi	
}

main $@
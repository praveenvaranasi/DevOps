#! /bin/sh

start_instance()
{
	echo "starts_instance"
}

main()
{
	read -p "Enter the function you want to perform: " funcName
	echo $funcName
	case $funcName in
		"start_instance")
			
			start_instance
			;;
	esac
}

main
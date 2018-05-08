#! /bin/sh

# Place all the targets that needs to be shown in targets variable
targets="a b c"

# Uncomment the following when using other ANT_HOME apart from environment variables 
#ANT_HOME=

listTargets()
{
	echo -n "The following are the targets: "
	for i in ${targets}
	do
		echo "${i}"
	done
	read -p "Enter the target name to be executed: " target
	${ANT_HOME}/bin/ant $target
	if [ $? -eq 0 ]
	then
		echo "Successfully executed"
	fi
}	

listTargets

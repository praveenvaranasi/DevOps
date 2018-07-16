#! /bin/sh
inventory_file="hosts"

delete_the_node_entries()
{
	hosts_file=$1
    lc=`wc -l ${hosts_file} | cut -d ' ' -f1`
    temp=$(cat -n ${hosts_file} | sed -n -e '/nodes/p' | sed -e 's/[[:space:]]\+/ /g' | cut -d ' ' -f2)
    sl=`expr ${temp} + 1`
    if [ $lc -eq $sl ] ; then
    	sed -i "${sl}d" ${hosts_file}
	echo "deleted the nodes group entry"
    elif [ $lc -eq $temp ] ; then
        echo "No entries in hosts group"
    elif [ $lc -gt $sl ] ; then
        sed -i "${sl},${lc}d" ${hosts_file}
	echo "deleted the nodes group entries"
    fi
}

cleanup()
{
    rm -f ~/temp/agent.jar ~/temp/jenkins-cli.jar
    delete_the_node_entries ${inventory_file}
}

cleanup

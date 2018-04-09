#! /bin/sh

while read f
do 
	case $f in 
		"init:" ) echo "found the word init" ;;
		"cluster:" ) echo "found the word cluster" ;;
	esac
done < builder.txt

#echo "*****************************************************************************"
#echo "*****************************************************************************"
#echo "*****************************************************************************"

#while f=`line`
#do 
#	case $f in 
#		"init:" ) echo "found the word init" ;;
#		"cluster:" ) echo "found the word cluster" ;;
#	esac
#done < builder.txt

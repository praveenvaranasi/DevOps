#! /bin/sh

Input_String=hi
while [ $Input_String != "hello" ]
do
	echo "enter some input"
	read Input_String
	echo "you have typed $Input_String"
done

echo "Need to press ^c to exit here"
while : 
do
	echo "Enter some Input"
	read Input
	echo "you've typed ${Input}"
done


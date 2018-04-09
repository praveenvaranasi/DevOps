#!/bin/sh
# This is a comment!
echo "Hello      World"       
echo "Hello World"				
echo "Hello * World"		  # echo prints the content as it is that appears inside the double Quotes
echo Hello * World			   
echo Hello      World		  # echo strips the spaces in between the 'parameters' and will print as single space
echo "Hello" World
echo Hello "     " World
echo "Hello "*" World"
echo `hello` world				# echo evaluates the content inside the `` as command and executes it and prints the output			
echo `pwd` world
echo 'hello' world

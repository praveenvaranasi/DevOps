#! /bin/sh

for i in 1 2 3 4 5 * `ls` # both * and `ls` gives the same output i.e., list of files in the current direcctory
do
	echo ${i}
done

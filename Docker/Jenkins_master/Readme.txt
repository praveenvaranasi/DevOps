Prerequisities:

	To build an Jenkins Installation image using the "Dockerfile", do the following steps:

1. Create a directory called "jenkins"

2. Place the docker file, Jenkins Installation folder contents into 'jenkins_home' directory and jenkins.war file inside jenkins directory

3. Build the image 
		docker build -t <tag-name> .
4. check for the image created
		docker image ls
	- This should give "tag-name" image
5. Launch the container in normal mode by running the image 

		docker run -p 8080:8080 <tag-name>

   To run the container in detached/background mode, run it in the following way

		docker run -d -p 8080:8080 <tag-name>

Finally, connect to the Jenkins server using "<machine-public-ip>:8080"

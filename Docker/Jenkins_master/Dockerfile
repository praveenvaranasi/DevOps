# Base Image is Java
From java:8-jdk

#Setting Container work directory to jenkins
WORKDIR /jenkins

#Adding the current directory to newly created jenkins directory
ADD . /jenkins

#Setting JENKINS_HOME env variable
ENV JENKINS_HOME /jenkins/jenkins_home

#Exposing ports to listen requests
EXPOSE 8080
EXPOSE 50000

#Starting Jenkins server in container
CMD ["/usr/bin/java", "-jar", "jenkins.war"]

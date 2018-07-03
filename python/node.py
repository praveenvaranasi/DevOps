import sys
from xml.etree import ElementTree as ET

class add_node:
    """ Contains the definition that adds details to the node's config.xml file """

    def modify_details(self, file_path, elem_to_find, node_ip):
        
        try:      
            tree = ET.parse(file_path)
            node_root = tree.getroot()
            for i in node_root.iter(elem_to_find):
                command = "ssh -o StrictHostKeyChecking=no -i /home/Praveen-AWS.pem ec2-user@"+node_ip+" java -jar /home/ec2-user/agent.jar"
                i.text = command
            tree.write(file_path)
            print("Configured config.xml for jenkins_node")
        except FileNotFoundError as fnferr:
            print("Please check the file path once: {0}".format(fnferr))



if __name__ == "__main__":

    path = sys.argv[1]
    node_elem = sys.argv[2]
    ip_add = sys.argv[3]
    obj = add_node()
    obj.modify_details(path, node_elem, ip_add)

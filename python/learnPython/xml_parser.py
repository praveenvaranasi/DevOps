from xml.etree import ElementTree as ET
import os


def parse_xml():
    try:
        print(os.getcwd())
        xml_tree = ET.parse('configs.xml')  # Reads xml file (ET = Element tree (reads entire xml -
        # - structure and stores in s tree format))
        result = xml_tree.getroot()  # Gives root element
        print(result.tag)  # prints the tag name of the root
        for child in result:  # iterating over the root's children node
            print(child.tag, child.attrib)
            pass
    except FileNotFoundError:
        print("The file you want to use is not there in the specified location")
    pass


def accessing_elements():
    """ This definition shows the functionality of few methods related to xml processing """
    try:     
        xml_tree = ET.parse('Configs.xml')
        head = xml_tree.getroot()
        print(head, head.tag)
        # for child in head:
        #     print(child.tag, child.attrib)
        # for check in head.iter('{http://fiorano.com/types/common}LOGGER'):
        #     print(check.attrib)
        # for get_elements in head.findall('{http://fiorano.com/types/common}LOGGER'):
        #     print(get_elements.attrib)
        #     print(get_elements.get('LogLevel'))
        #     print(get_elements.get('ObjectName'))
        logger_element = head.findall('{http://fiorano.com/types/common}LOGGER')
        print(logger_element)
        for logger_element_atts in logger_element:
            print(logger_element_atts.find('{http://fiorano.com/types/common}Appender').get('AppenderName'))
            print(logger_element_atts.find('{http://fiorano.com/types/common}Appender').get('FileName'))
    except FileNotFoundError:
        print("The file you are trying to use is not present in the specified location")
        pass
    except AttributeError:
        print("The attribute you're looking for is not there under the present tag. Please check and rectify")


if __name__ == "__main__":
    #parse_xml()
    accessing_elements()
    pass

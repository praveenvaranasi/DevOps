import xml.etree.ElementTree as ET
import sys
from sys import argv


def microservice_resources(src_file, dest_file, element, sub_element, sub_element_attribute, *attribute_values):
    """ The module adds resources"""
    try:
        tree = ET.parse(src_file)
        root = tree.getroot()
        for resultant_element in root.iter():
            if element == resultant_element.tag:
                base_element = ET.Element(resultant_element)
                for temp in attribute_values:
                    sub_base_element = ET.SubElement(base_element, sub_element)
                    sub_base_element.set(sub_element_attribute, temp)
                    sub_base_element.tail = "\n\t\t\t"
                    resultant_element.insert(0, sub_base_element)
                    print('added '+sub_element_attribute+' attribute with value '+temp+' to the '+sub_element+' element under the '+resultant_element.tag)
        tree.write(dest_file)

    except AttributeError:
        print('The attribute you are looking for is not appearing here')
    except FileNotFoundError:
        print('The file '+src_file+' is not present in the specified location')
    except ET.ParseError:
        print('The file '+src_file+' is a malformed xml')
    except IsADirectoryError:
        print('The parameter source file '+src_file+' passed is a directory. It has to be an xml file' )

if __name__ == "__main__":
    source_file = sys.argv[1]
    destination_file = sys.argv[2]
    elem = sys.argv[3]
    sub_elem = sys.argv[4]
    attribute_name = sys.argv[5]
    print(source_file, destination_file, elem, sub_elem, attribute_name, *argv[6:])
    microservice_resources(source_file, destination_file, elem, sub_elem, attribute_name, *argv[6:])
    pass

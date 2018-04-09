from xml.etree import ElementTree
import os


def xml_processing():
    """ Parses the XML"""

    path = os.getwd()
    # path = os.chdir('../')
    print(path)
    xml_file = ElementTree.parse('')  # Parses XML File
    result = xml_file.getroot()  # Gets the root element
    print(result)  # Prints the tag along with the position in hexadecimal format
    print(result.tag)  # Prints the tag alone
    list_key = []
    list_value = []
    for child in result:
        print(child.tag, child.attrib)
        list_key.append(child.tag)
        list_value.append(child.attrib)
        pass
    print(len(list_key), list_key)
    print(len(list_value), list_value)
    pass


if __name__ == "__main__":
    xml_processing()
    pass

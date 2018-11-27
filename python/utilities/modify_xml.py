import xml.etree.ElementTree as ET
import sys


def edit_infoxml(location, element, text, tail_content):
    """ This module adds few elements/sub-elements to the Info.plist xml """
    try:
        tree = ET.parse(location)
        root = tree.getroot()  # root element
        dict_element = (root.findall('dict'))[0]  # dict element
        array_elem_list = [array_elem for array_elem in dict_element if array_elem.tag == "array"]  # creat-
        # -ing list of array elements
        elem = ET.Element(array_elem_list[1])
        sub_elem = ET.SubElement(elem, element)  # adding element to the array element
        sub_elem.text = text
        if tail_content == "yes":
            sub_elem.tail = "\n\t\t\t"
            array_elem_list[1].insert(0, sub_elem)
            tree.write(location)  # creating file with the changes
        elif tail_content == "no":
            sub_elem.tail = ""
            array_elem_list[1].insert(0, sub_elem)
            tree.write(location)  # creating file with the changes
        else:
            print("please provide the valid tail content option (yes/no)")

    except FileNotFoundError:
        print('The file '+location+' is not present in the location')
    except ET.ParseError:
        print('The file '+location+' is not well-formed xml')


if __name__ == "__main__":
    location, element, text, tail_content = sys.argv[1], sys.argv[2], sys.argv[3], sys.argv[4]
    edit_infoxml(location, element, text, tail_content)

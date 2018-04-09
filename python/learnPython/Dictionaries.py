def dictionary():
    """ This program gives an idea about few things
    
    1. Gives an idea on dictionary usage
    2. looping techniques"""
    example_dictionary = {'hi': 'wish', 'bye': 'wish'}
    # using items to retrieve the contents of a declared Dictionary
    for key, value in example_dictionary.items():
        print("Key is " + key, "value is " + value)
        pass

    # using enumerate to get the index and value of a list
    en_list = ['a', 'b', 'c']
    for index, value in enumerate(en_list):
        print("index is " + str(index), "value is " + value)
        pass
    pass

if __name__ == "__main__":
    dictionary()
    pass

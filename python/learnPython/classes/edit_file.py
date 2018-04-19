class edit_file:
    """ This class edits the file and places the content into it"""

    def add_the_content(self, filename):
        """ This module adds the content at specified file """

        try:
            var = "I'm praveen"
            with open(filename, 'r') as file:
                contents = file.readlines()
                file.close()
            print(contents)
            contents.insert(3, "I'm praveen\n")
            with open(filename, 'w') as dest:
                contents = "".join(contents)
                dest.write(contents)
                dest.close()
        except FileNotFoundError:
            print("The file you are looking does not exists. Please check the path")


if __name__ == "__main__":
    obj = edit_file()
    path = input("Enter the file path: \n")
    obj.add_the_content(path)
    pass

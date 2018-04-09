import sys
from sys import argv

def check_build_number():

    build = input("Enter the build number:\n")
    build_numbers = [10561, 10562]
    print(len(build_numbers))
    for i in build_numbers:
        print(i)
        if i == build:
            resultant_build_number = int(build + "1")
            print(resultant_build_number)
        pass
    # for i in range(0, 10):
    #     resultant_build_number = resultant_build_number + i
    #     print(resultant_build_number, end=",")
    # pass


def copy_jars():
    import os
    import sys
    #os.

def unpack(*jars):
    for i in range(0, jars.__len__()):
        print(i)

def mod1():
    print("I'm mod1. you've called me!!!")

def mod2():
    print("I'm mod2. You've invoked me")

if __name__ == "__main__":

    # check = check_build_number  # Renaming mechanism of the function
    # check()
    # unpack(*argv[1:])
    if sys.argv[1] == "one":
        mod1()
    else:
        mod2()

    pass

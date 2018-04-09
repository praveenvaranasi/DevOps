import sys
import os


def exception_try():
    """ This is for knowing about Error handking in GIT """

    try:
        var = int(input("Enter a value: "))
        result = 10 // var
        print(result)

    # except ZeroDivisionError:
    #     print("Zero shouldnt be the input")
    # except ValueError:
    #     print("Give integers only")
    except (ZeroDivisionError, ValueError):
        print("Errors have come. look into it and do the needful")


exception_try()
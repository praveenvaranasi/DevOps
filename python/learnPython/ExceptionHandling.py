def exception():
    try:
        a = int(input('Enter the Value of the variable a\n'))
        b = int(input('Enter the Value of the variable b\n'))
        print('Dividing a by b')
        result = a // b
        print(result)
    except ZeroDivisionError:
        print('you have Entered b value Zero. Please try something else')
    except ValueError:
        print('Only integer values are accepted. Dont enter other than Strings.')
    finally:
        print('understood!!')

exception()

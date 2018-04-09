def fibonacci_series(n):
    """ This function returns fibonacci series numbers up to the limit specified
    
             This is implemented using the Optional argument parameter method. While Printing output, it prints each 
             value of a once in iteration.
    """
    a, b = 0, 1
    while b < n:
        print(a, end=" ")
        a, b = b, a + b
        pass


def fibonacci_list_implementation(n=10):

    """ This function also returns the  fibonacci series up to the specified limit
    
            This is implemented using the list. Instead of printing the value in each iteration, it prints all at a time
            using list.
            Also, it uses keyword arguments instead of using Positional arguments
    """
    a, b = 0, 1
    result = []
    while b < n:
        result.append(a)
        a, b = b, a + b
        pass
    print(result)
    print('The size of the resultant list is: ',len(result))


number = int(input('Enter the limit till which the fibonacci series has to be printed: \n'))
fibonacci_list_implementation(number)
fibonacci_series(number)

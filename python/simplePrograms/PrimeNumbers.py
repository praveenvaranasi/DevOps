#Prime Number - The number that's only divisible by number one and itself

def prime_numbers_check(limit):
    """ This function checks whether the provided Number is a prime or not"""
    i = 0
    for i in range(2, limit):
        if limit % i == 0:
            print(limit, 'is not a prime number')
            break
    else:
        print(limit, 'is a prime number')

limit = int(input('Enter the number to be checked:\n'))
#prime_numbers_check(limit)


def list_prime_numbers(limit):
    """ This functions prints all the prime numbers till the limit"""
    i, j = 0, 0
    for i in range(2, limit):
        for j in range(2, i):
            if i % j == 0:
                print(i, 'is not a prime number') # try Implementing list here
                break
        else:
            print(i, 'is a prime number')

list_prime_numbers()

#Implement Other methods ( 2 to n/2 )
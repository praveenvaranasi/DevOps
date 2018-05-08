class PrimeNumbers:
    """ This class contains the definitions thats lists the prime numbers """
    
    def list_primes(self, limit):
        """ Definition that lists the prime numbers till the limit passed """

        for i in range(2, limit):
            if limit % i == 0:
                print(limit, "is not a prime number")
                break
        else:        
            print(limit, "is a prime number")


    def prime_list(self, limit):

        list = []
        limit = int(limit) + 1
        for temp in range(1, limit):
            for j in range(2, temp):
                if temp % j == 0:
                    break
            else:
                list.append(temp)
        print(list)
        print(len(list))

obj = PrimeNumbers()
num = int(input("Enter the value to be checked for prime number: "))
print(num)
obj.list_primes(num)
obj.prime_list(num)

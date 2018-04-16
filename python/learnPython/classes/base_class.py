class base:
    """ This demonstrates the structure of a class """

    sample = 10

    global string_sample
    string_sample = 'global_scope'

    def string_slice(self):
        """ contains string slicing code """

        try:
            string_sample = "I'm non local"
            print("The word is {0}".format(string_sample))
            print(string_sample[0:13])
        except ValueError:
            print('Provide corresponding data type value to the string_sample')

    def design(self, sym):
        for i in range(0, 40):
            print(sym, end='')


class derived(base):
    base.string_slice("")



def main_mod():

    character = str(input("Enter a symbol: "))
    base.design(' ' ,character)
    print("\nInvoking the class using Instance Object")
    base.design('',character)
    Obj = base()
    Obj.string_slice()
    print(Obj.__doc__, Obj.string_slice.__doc__)
    base.design('', character)
    print('\nInvoking the Class using Class Object')
    base.design('', character)
    print('\n'+str(base.sample))
    base.string_slice('hello')

main_mod()


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
            print(string_sample[0:12])
        except ValueError:
            print('Provide corresponding data type value to the string_sample')

def design():
    for i in range(0,40):
        print('*',end='')
    # print('\n')

def main_mod():


    design()
    print("\nInvoking the class using Instance Object")
    design()
    Obj = base()
    Obj.string_slice()
    print(Obj.__doc__, Obj.string_slice.__doc__)
    design()
    print('\nInvoking the Class using Class Object')
    design()
    print('\n'+str(base.sample))
    base.string_slice('hello')

main_mod()


import os


class say:
    print('entered into class at least')
    print(os.path.join("/root", "Desktop", "installed", "Fiorano", str(11), "build.properties"))

    def get_build_number(self):
        try:
            file = open(os.path.join("/root", "Desktop", "installed", "Fiorano", str(11), "build.properties"), 'r+')
            print('hi')
            print(os.path.join("/root", "Desktop", "installed", "Fiorano", str(11), "build.properties"))
            file.read()
            file.close()
            print('tried')
        except FileNotFoundError:
            print('Specified file did n\'t exists in the path')
            pass
        pass
    pass
pass

run = say()
run.get_build_number()



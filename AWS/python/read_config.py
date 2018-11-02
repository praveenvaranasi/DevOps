import configparser
import sys
import os.path
import boto3

class GetConfigs:

    def get_the_filecontents(self, bucket_name, s3_keyname):

        s3 = boto3.resource('s3')
        file_obj = s3.Object('praveenvp', 'cred.ini').get()
        file_content = file_obj['Body'].read()
        return file_content
         

    def read_config(self, file_name, section, key):
        """ Reads the configuration from ini files"""
        try:
            if os.path.isfile(file_name):
                print("this is file")
            else:
                print("The file "+file_name+" doesnt exist")
                exit()
            config = configparser.ConfigParser()
            config.read(file_name)
            return config[section][key]
        except KeyError as ke:
            print("KeyError has occured. Please check the passed Section and its Key Value once and try again")
        except NameError as ne:
            print(ne)

if __name__ == "__main__":
    
    s3_keyname = sys.argv[2]
    bucket_name = sys.argv[1]
    section = sys.argv[3]
    key = sys.argv[4]
    obj = GetConfigs()
    file_contents = obj.get_the_filecontents(bucket_name, s3_keyname )
    print(obj.read_config(file_contents, section, key))
    

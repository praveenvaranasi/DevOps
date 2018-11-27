import sys
from sys import argv
from smtplib import SMTP
from smtplib import SMTPAuthenticationError

class SendMail:
    """ sends the mail by reading the file's content """

    def read_the_contents(self, file_path):
        """ Reads the file contents"""
        
        try:
            with open(file_path, 'r') as f:
                message_content = f.read()
            return message_content
        except IOError as ierr:
            print('I/O Error. Please check the file Path. following is the stacktrace: \n {0}'.format(ierr))
            exit()

    def mail(self, msg_content, *to_addresses):
        """ Mails the file's content to the recepients """

        try:
                to_list = ','.join(to_addresses)
                message = 'From: Jenkins Server\nTo:'+to_list+' \nSubject: Details of the newly created Instance \n' + '\n' +msg_content
                smtp_obj = SMTP('smtp.gmail.com:587')
                smtp_obj.starttls()
                smtp_obj.login('<username>','<password>')
                smtp_obj.sendmail('praveenbh.varanasi@gmail.com', to_addresses, message)
                smtp_obj.quit()
        except SMTPAuthenticationError as err:
            print('AuthenticationError: {0}'.format(err))
        except RuntimeError as rterr:
            print('RuntimeError: {0}'.format(rterr))


if __name__ == "__main__":
    file_path = sys.argv[1]
    obj = SendMail()
    obj.mail(obj.read_the_contents(file_path), *argv[2:])

import boto3

def get_an_idea():
    
    ec2 = boto3.resource('ec2')
    #instances = ec2.instances.filter(Filters=[{'Name': 'instance-state-name', 'Values': ['running']}])
    all_instances = ec2.instances.all()
    for instance in all_instances:
        print instance.id

get_an_idea()

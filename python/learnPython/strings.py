# Strings
sampleString = 'python'
print("The length of the sampleString is", len(sampleString))
print(sampleString[0:])
print(sampleString[0:4])
print(sampleString[:3])
print(sampleString[:])
print(sampleString[:100])
print(sampleString[100:])  # prints nothing

# List
sampleList = [1, 2, 3, 4, 5]
print("Then length of the sampleList is", len(sampleList))
sampleList[0] = 2
print(sampleList[:])
print(sampleList[0] + sampleList[3]);

# Normal-String
# Execute the very following line to encounter the error when running.
# print('C:\Users\ndmin\Desktop')
print(r'C:\Users\admin\nDesktop')

if sampleList.count(1) == 0:
    print('there!!')




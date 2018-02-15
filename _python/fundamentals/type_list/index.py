#input
mixed = ['magical unicorns',19,'hello',98.98,'world']

'''
#output
"The list you entered is of mixed type"
"String: magical unicorns hello world"
"Sum: 117.98"
'''

# input
ints = [2,3,1,7,4,12]

'''
#output
"The list you entered is of integer type"
"Sum: 29"
'''

# input
strs = ['magical','unicorns']

'''
#output
"The list you entered is of string type"
"String: magical unicorns"
'''

count = 0
number = 0
string = 0
for val in strs:
    count += 1
    # print "on line 30"
    print type(val)
    if type(val) is int or type(val) is float:
        print "val is of number type"
        number += 1
    elif type(val) is str:
        print "val is str"
        string += 1

print "the len of the input was: {}".format(count)
print "I found {} numbers in the list".format(number)
print "I found {} strings in the list".format(string)

if string and number:
    print "The list you entered is of mixed type"
elif string:
    print "The list you entered is of string type"
elif number:
    print "The list you entered is of number type"
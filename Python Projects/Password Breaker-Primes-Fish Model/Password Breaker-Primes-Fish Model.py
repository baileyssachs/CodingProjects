# Problem A: find_password
#==========================================
# Purpose:
#   Given an encrypted file, tries every possible four letter lowercase
#   password for that file until one works, and then returns the password.
# Input Parameter(s):
#   filename is a string representing the name of the encrypted file.
#   The file must be in the same folder as this script.
# Return Value:
#   Returns the password that successfully decrypts the given file
#==========================================

def find_password(filename):
    fp = open(filename)
    data = fp.read()
    password = ''
    p1 = 97
    p2 = 97
    p3 = 97
    p4 = 97
    for i in range(25):
        for c in range(25):
            for z in range(25):
                for x in range(25):
                    password = chr(p1 + i) + chr(p2 + c) + chr(p3 + z) + chr(p4 + x)
                    if decrypt(data, password):
                        return password
        


# Problem B: count_primes
#==========================================
# Purpose:
#   Prints out all prime numbers between low and high, inclusve, and
#   returns a count of how many there were.
# Input Parameter(s):
#   low is a positive integer 
#   high is a positive integer, which should be >= low
# Return Value:
#   Returns the number of prime numbers between low and high, inclusive
#==========================================
def count_primes(low, high):
    count = 0
    for i in range(low,high + 1):
        prime = True
        if i > 1:
            for c in range(2,int(i**0.5) + 1):
                if i % c == 0:
                    prime = False
            if prime:
               print(str(i) + " is prime.")
               count += 1
    return count
    

# Problem C: population
#==========================================
# Purpose:
#   Simulates the population of smallfish, middlefish, and bigfish over time
# Input Parameter(s):
#   small is an integer, the initial number of smallfish in the lake
#   middle is an integer, the initial number of middlefish in the lake
#   big is an integer, the initial number of bigfish in the lake
# Return Value:
#   Returns the number of weeks required for one of the populations to
#   fall below 10, or 100 if the populations are all still >= 10 after
#   100 weeks
#==========================================
def population(small, middle, big):
    small2 = small
    middle2 = middle
    big2 = big
    if small < 10:
        return 0
    elif middle < 10:
        return 0
    elif big < 10:
        return 0
    for i in range(1,101):
        small *= 1.1
        middle *= 0.95
        big *= 0.9

        bigEat = 0.00025 * middle2 * big2
        middleEat = 0.0002 * small2 * middle2

        small = small - middleEat
        middle = middle - bigEat

        middle += (middleEat * 0.5)
        big += (bigEat * 0.8)

        print("week " + str(i) + " - small: " + str(int(small)) + " middle: " + str(int(middle)) + " big: " + str(int(big)))
        small2 = small
        middle2 = middle
        big2 = big
        if(small < 10):
            return i
        elif(middle < 10):
            return i
        elif(big < 10):
            return i

    return 100
        



#DO NOT EDIT ANYTHING BELOW THIS LINE
#Below are helper functions used for decrypting the text files.
#You don't have to understand how any of these work.

# decrypt
#==========================================
# Purpose:
#   Check whether the password is correct for a given encrypted
#   file, and print out the decrypted contents if it is.
# Input Parameter(s):
#   data is a string, representing the contents of an encrypted file.
#   password is a four letter lowercase string, representing the password
#   used to encrypt/decrypt the file contents.
# Return Value:
#   Returns True if the password is correct and the file contents
#   were printed.  Returns False and prints nothing otherwise.
#==========================================
def decrypt(data, password):
    data = data.split('\n')
    if encode(password) == int(data[0]):
        print(vigenere(data[1],password))
        return True
    return False

# encode
#==========================================
# Purpose:
#   Turn a password into a ~9 digit number
# Input Parameter(s):
#   key is a four letter string representing a password
# Return Value:
#   Returns a number between 0 and 547120140, using modular exponentiation
#   to make it difficult to reverse engineer the password from the number.
#==========================================
def encode(key):
    total = 0
    for ltr in key:
        total += ord(ltr)
        total *= 123
    return pow(total,2011,547120141)

# vigenere
#==========================================
# Purpose:
#   Decipher a message using the Vigenere cipher
# Input Parameter(s):
#   msg a string, representing the encrypted message
#   key is a four letter string, representing the cipher key
# Return Value:
#   Returns a string representing the deciphered text
#==========================================
def vigenere(msg,key):
    i = 0
    out_msg = ''
    for ltr in msg:
        out_msg += chr((ord(ltr)-ord(key[i]))%28 +97)
        i = (i+1)%len(key)
    return out_msg.replace('{',' ').replace('|','.')



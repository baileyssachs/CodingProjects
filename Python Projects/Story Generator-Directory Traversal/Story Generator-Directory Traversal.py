import random
#==========================================
# Purpose: to return the first word in each sentence
# Input Parameter(s): file name fname
# Return Value(s): returns a list of all the first words in each sentence
#==========================================
def first_words(fname):
    lines = []
    first = []
    try:
        with open(fname, "r") as file:
            lines = file.readlines()
            for i in range(len(lines)):
                temp = lines[i].split(" ")
                first.append(temp[0])
        return first
    except:
        print("File name is invalid")

#==========================================
# Purpose: return a list of al the words after each word in every sentence
# Input Parameter(s): file name fname
# Return Value(s): returns a dictionary with all of the words after each word
#==========================================
def next_words(fname):
    with open(fname, "r") as file:
        lines = file.readlines()
        words = {}
        for i in range(len(lines)):
            temp = lines[i].split(" ")
            for c in range(len(temp) - 1):
                if words.get(temp[c], -1) != -1:
                    stuff = words[temp[c]]
                    if temp[c + 1] == ".\n":
                        stuff.append(".")
                    else:
                        stuff.append(temp[c+1])
                    words[temp[c]] = stuff
                else:
                    if temp[c+1] == ".\n":
                        words[temp[c]] = ["."]
                    else:
                        words[temp[c]] = [temp[c + 1]]
    return words

#==========================================
# Purpose:returns a randomized story based off the frequency of words in a text file
# Input Parameter(s): file name fname
# Return Value(s): no return
#==========================================
def fanfic(fname):
    first = first_words(fname)
    filler = next_words(fname)
    for i in range(10):
        randomfirst = random.choice(first)
        sentence = randomfirst
        x = filler[randomfirst]
        while x != ".":
            temp = ""
            if len(x) > 1:
                temp = random.choice(x)
            else:
                temp = x[0]
            sentence += " " + str(temp)
            if temp == ".":
                x = "."
            else:
                x = filler[str(temp)]

        print(sentence)

#==========================================
# Purpose: adds up all of the bytes of each text file and returns it.
# Input Parameter(s): dictionary directory
# Return Value(s): sum of all the bytes of each text file
#==========================================
def total_txt_size(directory):
    x = directory.keys()
    Sum = 0
    for i in x:
        if type(directory[i]) == int:
            if ".txt" in i:
                Sum += directory[i]
        else: 
                Sum += total_txt_size(directory[i])
    return Sum
    

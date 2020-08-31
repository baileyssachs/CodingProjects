import random
#==========================================
# Purpose: This function determines which students are good students(They
#have good grades, a good life, and a good ammount of sleep)
# Input Parameter(s): list of which students have good grades
# list of students which have a good life
# list of students who get a good amount of sleep
# Return Value(s): returns a list of all the good students
#==========================================
def wizards(grades,life,sleep):
    students = []
    for i in grades:
        students.append(i)
    for c in students:
        if (c in life) == False:
            students.remove(c)
    for x in students:
        if (x in sleep) == False:
            students.remove(x)
    return students
#==========================================
# Purpose:This function returns a list of the open indexes on the board
# Input Parameter(s): a list of all the values at each index on the board
# Return Value(s): returns a list of all the indexes that arent filled with an x or an o
#==========================================
def open_slots(board):
    openSpots = []
    for i in range(len(board)):
        if board[i] == '-':
            openSpots.append(i)
    return openSpots
#==========================================
# Purpose: This function checks if either x or o has won. If neither then it returns
# a draw if all spots are filled and just a dash if the game isnt over
# Input Parameter(s): a list of all the values at each index on the board
# Return Value(s): it returns an 'X' if x has won, an 'O' if o has won,
# a 'D- if it was a draw and a '-' if the game is not yet over
#==========================================
def winner(board):
    list1 = [board[0],board[1],board[2]]
    list2 = [board[3],board[4],board[5]]
    list3 = [board[6],board[7],board[8]]
    megaList = [list1,list2,list3]

    #Horizontal Checks X
    if(list1[0] == 'X' and list1[1] == 'X' and list1[2] == 'X') == True:
        return 'X'
    elif (list2[0] == 'X' and list2[1] == 'X' and list2[2] == 'X') == True:
        return 'X'
    elif (list3[0] == 'X' and list3[1] == 'X' and list3[2] == 'X') == True:
        return 'X'

    #vertical Checks X
    if(list1[0] == 'X' and list2[0] == 'X' and list3[0] == 'X') == True:
        return 'X'
    elif(list1[1] == 'X' and list2[1] == 'X' and list3[1] == 'X') == True:
        return 'X'
    elif(list1[2] == 'X' and list2[2] == 'X' and list3[2] == 'X') == True:
        return 'X'

    #Diag X checks
    if(list1[0] == 'X' and list2[1] == 'X' and list3[2] == 'X') == True:
        return 'X'
    elif(list1[2] == 'X' and list2[1] == 'X' and list3[0] == 'X') == True:
        return 'X'




    #Horizontal Checks O
    if(list1[0] == 'O' and list1[1] == 'O' and list1[2] == 'O') == True:
        return 'O'
    elif (list2[0] == 'O' and list2[1] == 'O' and list2[2] == 'O') == True:
        return 'O'
    elif (list3[0] == 'O' and list3[1] == 'O' and list3[2] == 'O') == True:
        return 'O'

    #vertical Checks O
    if(list1[0] == 'O' and list2[0] == 'O' and list3[0] == 'O') == True:
        return 'O'
    elif(list1[1] == 'O' and list2[1] == 'O' and list3[1] == 'O') == True:
        return 'O'
    elif(list1[2] == 'O' and list2[2] == 'O' and list3[2] == 'O') == True:
        return 'O'

    #Diag O checks
    if(list1[0] == 'O' and list2[1] == 'O' and list3[2] == 'O') == True:
        return 'O'
    elif(list1[2] == 'O' and list2[1] == 'O' and list3[0] == 'O') == True:
        return 'O'

    for i in board:
        if i == '-':
            return '-'

    return 'D'
#==========================================
# Purpose: this function simulates a game of tic tac toe in which
# random positions are picked for each piece until the game is over
# Input Parameter(s): None
# Return Value(s): it returns 'X' if x won the game, 'O' if o won or a 'D' if it was a draw
#==========================================
def tic_tac_toe():
    board = ['-','-','-','-','-','-','-','-','-',]
    while winner(board) != 'X' and winner(board) != 'O' and winner(board) != 'D':
        list1 = open_slots(board)
        int1 = random.randint(0,(len(list1) - 1))
        board[list1[int1]] = 'X'
        if  winner(board) == 'X' or winner(board) == 'O' or winner(board) == 'D':
            break
        list2 = open_slots(board)
        int2 = random.randint(0,(len(list2)-1))
        board[list2[int2]] = 'O'

    return winner(board)
#==========================================
# Purpose: This function simulates n number of games of tic tac toe then prints the results of those games as 3 seperate integers.
# Input Parameter(s): int n for how many times the function will simulate a game of tic tac toe
# Return Value(s): No return
#========================================== 
def play_games(n):
    x = 0
    o = 0
    d = 0
    for i in range(n):
        result = tic_tac_toe()
        if result == 'X':
            x += 1
        elif result == 'O':
            o += 1
        elif result == 'D':
            d += 1
    print("X wins: " + str(x))
    print("O wins: " + str(o))
    print("Draws: " + str(d))

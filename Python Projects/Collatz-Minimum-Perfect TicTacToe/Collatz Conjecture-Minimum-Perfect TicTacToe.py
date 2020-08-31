import random
#==========================================
# Purpose: This function takes an int and computes until it is one
# Input Parameter(s): int n to be computed
# Return Value(s): returns a list of the steps taken to get to 1
#==========================================

def collatz(n):
    if n == 1:
        return [n]

    if n % 2 != 0:
        x = int((n * 3) + 1)
        return [n] + collatz(x)
    else:
        return [n] + collatz(int(n/2))

#==========================================
# Purpose: This function finds the minimum number in a list recursively
# Input Parameter(s):List of numbers to find the minimum on
# Return Value(s): returns the smallest number in the list
#==========================================

def find_min(num_list):
    if len(num_list) == 1:
        return num_list[0]
    else:
        minNum = find_min(num_list[1:])
        test = num_list[0]
        if minNum < test:
            test = minNum
        return test




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
    board = ["-"] * 9
    turn = "X"
    while winner(board) == "-":
        slots = open_slots(board)
        pick = random.choice(slots)
        if turn == "X":
            board[pick] = "X"
            turn = "O"

        elif turn == "O":
            x = 5
            index = 0
            for i in range(len(open_slots(board))):
                temp = board[:]
                temp[open_slots(board)[i]] = "O"
                y = force_win(temp)
                if y < x:
                    x = y
                    index = open_slots(board)[i]
            board[index] = "O"
            turn = "X"

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



#==========================================
# Purpose: This function determines who can win in a given board state
# Input Parameter(s): list containing the state of the board
# Return Value(s):returns -1 if O can win, 1 if X can win and 0 if it is a draw
#========================================== 
def force_win(board):
    if winner(board) == "X":
        return 1
    elif winner(board) == "O":
        return -1
    elif winner(board) == "D":
        return 0

    
    z = open_slots(board)
    
    if len(z) % 2 == 0:
        x = 5
        for i in range(len(z)):
            temp = board[:]
            temp[z[i]] = "O"
            y = force_win(temp)
            if y < x:
                x = y
        return x
    else:
        x = -5
        for i in range(len(z)):
            temp = board[:]
            temp[z[i]] = "X"
            y = force_win(temp)
            if y > x:
                x = y
        return x

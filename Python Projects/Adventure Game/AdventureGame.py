#==========================================
# Purpose: return a string of the sound that the animal at each eight would make
# Input Parameter(s): Int Weight of the animal
# Return Value(s): Strinng of the sound that the animal makes
#==========================================
def sound(weight):
    if weight < 13:
        return "Yip"
    elif weight >= 13 and weight <= 30:
        return "Ruff"
    elif weight >= 31 and weight <= 70:
        return "Bark"
    else:
        return "Boof"


def choice(text1, option1, option2, option3):
    print(text1)
    print("1. " + option1)
    print("2. " + option2)
    print("3. " + option3)
    temp = True
    userVal = 0
    while temp == True:
        userVal = input("Choose 1, 2, or 3: ")
        if userVal == "1":
            return "1"
        elif userVal == "2":
            return "2"
        elif userVal == "3":
            return "3"
        else:
            print("Invalid option")

def adventure():
    state = 0
    userVal = choice("You enter a foggy and omnimous maze", "Go forward", "Go right", "Go left")
    if userVal == "1":
        print("You start walking forward, but suddenly the floor falls out from under you. You fall into a sppike pit and die. Better luck next time!")
        return False
    elif userVal == "2":
        print("You turn right and find a small log cabin.")
        state = 2
    elif userVal == "3":
        state = 3
        print("You turn right and find a road. You start walking down the road.")
              
    if state == 2:
        userVal = choice("You appproach the log cabin.", "Ignore the cabin and keep going straight", "Investigate inside the cabin", "Look around the cabin for supplies")
        if userVal == "1":
            print("You found a secret alcove and escape the maze! You Win!")
            return True
        elif userVal == "2":
            print("As you go open the door you hear a loud roar behind you and you turn around.")
            state = 4
        elif userVal == "3":
            print("As you quickly search the outside of the cabin you hear a loud roar behind you and you run back to the front of the cabin.")
            state = 4
    elif state == 3:
        userVal = choice("As you walk down the road you see a large castle in the distance and head over to it.", "Scale the wall of the castle and break in", "Just walk past and keep following the road", "Go present yourself to the guards at the front gate")
        if userVal == "1":
            print("The guards spot you and you get shot down. You fall to your death while bleedinng out. Try again!")
            return False
        elif userVal == "2":
            print("As you walk down a road you turn a corner and a beast roars.")
            state = 4
        elif userVal == "3":
            print("As you approach the front gate of the castle and greet the guards you explain your good intentions. They agree to let you meet with the king.")
            state = 5

    if state == 4:
        userVal = choice("A large beast appears in front of you. You have no weapons to confront the beast.", "Run past the beast into the brush of the forest", "Run towards a castle in the distance", "Run and try to headbutt the beast")
        if userVal == "1":
            print("You found a secret alcove in the brush and escape the maze! You Win!")
            return True
        elif userVal == "2":
            print("As you approach the front gate of the castle and greet the guards you explain your good intentions. They agree to let you meet with the king.")
            state = 5
        elif userVal == "3":
            print("You make it approximately one step before the beast swings its giant claws and rips you in two. Try harder next time!")
            return False

    if state == 5:
        userVal = choice("You are escorted into a giant chamber with the king sitting in his throne", "Explain that you just need help escaping", "Try to kill the king and take over his castle", "Beg him to let you take asylum in his castle")
        if userVal == "1":
            print("The king shows you mercy and sends guards with you to help you out of the maze. You escaped congrats on winning!")
            return True
        elif userVal == "2":
            print("One of the guards hiding in the corner shoots you with a crossbow before you get within 10 steps of the king. Good luck next time!")
            return False
        elif userVal == "3":
            print("The king shows you mercy and lets you take asylum in your castle. You become a loyal servant and stay under his rule the rest of your life. You won by surviving!")
            return True
            

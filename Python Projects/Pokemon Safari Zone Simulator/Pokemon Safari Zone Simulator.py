import tkinter as tk
import random
import math

#FIRST: Implement and test your Pokemon class below
class Pokemon:
    def __init__(self, n, dn, cr, sp):
        self.name = n
        self.dexNum = dn
        self.catchRate = cr
        self.speed = sp

    def __str__(self):
        return self.name

    def getName(self):
        return self.name
    def getNum(self):
        return self.dexNum
    def getCatch(self):
        return self.catchRate
    def getSpeed(self):
        return self.speed
    


#NEXT: Complete the class definition provided below
class SafariSimulator(tk.Frame):
    def __init__(self, master=None):
        print("In SafariSimulator init")
        #Read in the data file from pokedex.csv at some point here
        #It's up to you how you store and handle the data 
        #(e.g., list, dictionary, etc.),
        #but you must use your Pokemon class in some capacity
        self.pokemonlist = []
        with open("pokedex.csv", "r") as file:
            lines = file.readlines()
            for i in range(1, len(lines)):
                temp = lines[i]
                templist = temp.split(",")
                self.pokemonlist.append(Pokemon(templist[1],templist[0],templist[2],templist[3]))
        #Initialize any instance variables you want to keep track of
        self.safariBalls = 30
        self.captured = []
        #DO NOT MODIFY: These lines set window parameters and create widgets
        tk.Frame.__init__(self, master)
        master.minsize(width=275, height=350)
        master.maxsize(width=275, height=350)
        master.title("Safari Zone Simulator")
        self.pack()
        self.createWidgets()

        #Call nextPokemon() method here to initialize your first random pokemon
        self.nextPokemon()
    def createWidgets(self):
        #You need to create an additional "throwButton"
        self.throwButton = tk.Button(self)
        self.throwButton["text"] = "Throw Safari Ball(30 left)"
        self.throwButton["command"] = self.throwBall
        self.throwButton.pack()
        #See the image in the instructions for the general layout required
        #"Run Away" button has been completed for you as an example:
        self.runButton = tk.Button(self)
        self.runButton["text"] = "Run Away"
        self.runButton["command"] = self.nextPokemon
        self.runButton.pack()
        
        
        #A label for status messages has been completed for you as an example:
        self.messageLabel = tk.Label(bg="grey")
        self.messageLabel.pack(fill="x", padx=5, pady=5)

        #You need to create two additional labels:
        
        #Complete and pack the pokemonImageLabel here.
        ##self.image = tk.PhotoImage(file = "images/"
        #####edit this later???? i need to put in the image of the mon
        self.pokemonImageLabel = tk.Label()
        self.pokemonImageLabel.pack()            
        #Complete and pack the catchProbLabel here.
        self.catchProbLabel = tk.Label(bg = "grey")
        self.catchProbLabel.pack()
    def nextPokemon(self):        
        #This method must:
            #Choose a random pokemon
        rand = random.randint(0,150)
        tempPokemon = self.pokemonlist[rand]
        self.globaltempPokemon = tempPokemon
        self.messageLabel["text"] = "You encounter a wild " + str(tempPokemon)
        self.image = tk.PhotoImage(file = "sprites/" + tempPokemon.dexNum + ".gif")
        self.pokemonImageLabel["image"] = self.image
        catchRate = tempPokemon.getCatch()
        tempCatch = min(float(catchRate) + 1, 151) / 449.5
        self.globalCatch = tempCatch
        tempCatch *= 100
        tempCatch = math.floor(tempCatch)
        if tempCatch == 0:
            tempCatch = 1
        self.catchProbLabel["text"] = "Your chance of catching it is " + str(tempCatch) + "%"
            #Get the info for the appropriate pokemon
            #Ensure text in messageLabel and catchProbLabel matches the pokemon
            #Change the pokemonImageLabel to show the right pokemon
        
        #Hint: to see how to create an image, look at the documentation 
        #for the PhotoImage/Label classes in tkinter.
        
        #Once you generate a PhotoImage object, it can be displayed 
        #by setting self.pokemonImageLabel["image"] to it
        
        #Note: the PhotoImage object MUST be stored as an instance
        #variable for some object (you can just set it to self.photo).
        #Not doing this will, for weird memory reasons, cause the image 
        #to not be displayed.
        
    def throwBall(self):
        if self.safariBalls == 1:
            self.endAdventure()
            return

        x = random.random()
        
        if x < self.globalCatch:
            self.captured.append(self.globaltempPokemon)
            self.nextPokemon()
        else:
            self.messageLabel["text"] = "Aargh! It escaped!"
        self.safariBalls -= 1
        self.throwButton["text"] = "Throw Safari Ball(" + str(self.safariBalls) + "left)"
        #This method must:

            #Decrement the number of balls remaining
            #Try to catch the pokemon
            #Check to see if endAdventure() should be called

        #To determine whether or not a pokemon is caught, generate a random
        #number between 0 and 1, using random.random().  If this number is
        #less than min((catchRate+1), 151) / 449.5, then it is caught. 
        #catchRate is the integer in the Catch Rate column in pokedex.csv, 
        #for whatever pokemon is being targetted.
        
        #Don't forget to update the throwButton's text to reflect one 
        #less Safari Ball (even if the pokemon is not caught, it still 
        #wastes a ball).
        
        #If the pokemon is not caught, you must change the messageLabel
        #text to "Aargh! It escaped!"
        
        #Don't forget to call nextPokemon to generate a new pokemon 
        #if this one is caught.
        
    def endAdventure(self):
        self.pokemonImageLabel.pack_forget()
        self.throwButton.pack_forget()
        self.runButton.pack_forget()
        self.messageLabel["text"] = "You're all out of balls, hope you had fun!"
        if len(self.captured) == 0:
            temp = "Oops, you caught 0 Pokemon"
        else:
            temp = "You caught " + str(len(self.captured)) + " Pokemon:"
            for i in range(len(self.captured)):
                temp += "\n" + str(self.captured[i])
        self.catchProbLabel["text"] = temp
        #This method must: 

            #Display adventure completion message
            #List captured pokemon

        #Hint: to remove a widget from the layout, you can call the 
        #pack_forget() method.
        
        #For example, self.pokemonImageLabel.pack_forget() removes 
        #the pokemon image.




#DO NOT MODIFY: These lines start your app
app = SafariSimulator(tk.Tk())
app.mainloop()

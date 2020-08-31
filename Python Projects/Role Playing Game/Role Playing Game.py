class Adventurer:
#==========================================
# Purpose: Creates an instance of the adventurer class
# Input Parameter(s): string name, int level, int strength, int speed, int power
# Return Value(s): none
#==========================================
    def __init__(self, name, level, strength, speed, power):
        self.name = name
        self.level = level
        self.strength = strength
        self.speed = speed
        self.power = power
        self.HP = self.level * 6
        self.hidden = False

    def __repr__(self):
        temp = self.name + " - HP: " + str(self.HP)
        return temp
    
#==========================================
# Purpose: attacks the target by removing hp from them based on strength
# Input Parameter(s): target which is another adventurer
# Return Value(s): none
#==========================================
    def attack(self, target):
        if target.hidden == True:
            print(self.name + " can't see " + target.name)
        else:
            x = self.strength + 4
            target.HP -= x
            print(self.name + " attacks " + target.name + " for " + str(x) + " damage")

    def __lt__(self, other):
        if self.HP < other.HP:
            return True
        else:
            return False

     
class Fighter(Adventurer):
    def __init__(self, name, level, strength, speed, power):
        super().__init__(name, level, strength, speed, power)
        self.HP = self.level * 12

#==========================================
# Purpose: attack function for fighters that is stronger than the base adventurer
# Input Parameter(s): target that is being attacked
# Return Value(s): none
#==========================================
    def attack(self, target):
        if target.hidden == True:
            print(self.name + " can't see " + target.name)
        else:
            x = (2 * self.strength) + 6
            target.HP -= x
            print(self.name + " attacks " + target.name + " for " + str(x) + " damage")


class Thief(Adventurer):
    def __init__(self, name, level, strength, speed, power):
        super().__init__(name, level, strength, speed, power)
        self.HP = self.level * 8
        self.hidden = True

#==========================================
# Purpose: Attack function for theif, executes a sneak attack based on stealth
# Input Parameter(s): target that is being attacked
# Return Value(s):none
#==========================================t
    def attack(self, target):
        if self.hidden == False:
            super().attack(target)
        else:
            if target.hidden == True:
                if target.speed > self.speed:
                    print(self.name + " can't see " + target.name)
                else:
                    x = (self.speed + self.level) * 5
                    target.HP -= x
                    self.hidden = False
                    target.hidden = False
                    print(self.name + " sneak attacks " + target.name + " for " + str(x) + " damage")
            else:
                x = (self.speed + self.level) * 5
                target.HP -= x
                self.hidden = False
                target.hidden = False
                print(self.name + " sneak attacks " + target.name + " for " + str(x) + " damage")

class Wizard(Adventurer):
    def __init__(self, name, level, strength, speed, power):
        super().__init__(name, level, strength, speed, power)
        self.fireballs_left = self.power
#==========================================
# Purpose: attack function for wizard
# Input Parameter(s): target to be attacked
# Return Value(s): none
#==========================================
    def attack(self, target):
        if self.fireballs_left == 0:
            super().attack(target)
        else:
            target.hidden = False
            x = self.level * 3
            target.HP -= x
            self.fireballs_left -= 1
            print(self.name + " casts fireball on " + target.name + " for " + str(x) + " damage")
#==========================================
# Purpose: conducts a fight between two adventurers
# Input Parameter(s): adv1 which is an adventurer and adv2 which is also an adventurer
# Return Value(s): True if adv1 wins and false if adv2 wins and if both die
#==========================================
def duel(adv1, adv2):
    turn = 1
    while adv1.HP > 0 and adv2.HP > 0:
        if turn == 1:
            print(adv1)
            print(adv2)
        if turn == 1:
            adv1.attack(adv2)
            turn = 2
        else:
            adv2.attack(adv1)
            turn = 1
    print(adv1)
    print(adv2)
    if adv1.HP > 0 and adv2.HP <= 0:
        print(adv1.name + " wins!")
        return True
    elif adv1.HP <= 0 and adv2.HP > 0:
        print(adv2.name + " wins!")
        return False
    else:
        print("Everyone loses!")
        return False
    
#==========================================
# Purpose: conducts a tournament between all of the adventurers
# Input Parameter(s): adv_list which is a list of adventurers
# Return Value(s): returns the winner of the tounament
#==========================================
def tournament(adv_list):
    if len(adv_list) == 0:
        return
    elif len(adv_list) == 1:
        return adv_list[0]
    else:
        while len(adv_list) > 1:
            adv_list.sort()
            x = duel(adv_list[-2],adv_list[-1])
            if x == True:
                adv_list.pop(len(adv_list) - 1)
            else:
                adv_list.pop(len(adv_list) - 2)
        return adv_list[0]

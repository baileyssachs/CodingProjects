class Complex:
    def __init__(self,r,i):
        self.real = r
        self.imag = i

    def get_real(self):
        return self.real

    def get_imag(self):
        return self.imag

    def set_real(self, new_real):
        self.real = new_real

    def set_imag(self,new_imag):
        self.imag = new_imag

    def __str__(self):
        temp = str(self.real) + " + " + str(self.imag) + "i"
        return temp

    def __add__(self,other):
        x = self.real + other.get_real()
        y = self.imag + other.get_imag()
        z = Complex(x,y)
        return z

#==========================================
# Purpose: This function multiplies two complex numbers together
# Input Parameter(s): other which is another complex number
# Return Value(s): returns a new complex number which is the result of two other
# complex numbers multiplied
#==========================================
    def __mul__(self,other):
        x = self.real * other.get_real()
        y = self.imag * other.get_imag()
        z = x-y

        xtemp = self.real * other.get_imag()
        ytemp = self.imag * other.get_real()
        ztemp = xtemp + ytemp

        return Complex(z,ztemp)

    def __eq__(self,other):
        if self.real == other.get_real():
            if self.imag == other.get_imag():
                return True

        return False

class Employee:
#==========================================
# Purpose: Constructor for the Employee class
# Input Parameter(s): a line of text containing all of employees attributes seperated by commas
# Return Value(s): none
#==========================================
    def __init__(self, line):
        temp = line.split(",")
        self.name = temp[0]
        self.position = temp[1]
        self.salary = temp[2]
        self.seniority = temp[3]
        self.value = temp[4]

    def __str__(self):
        temp = self.name + ", " + self.position
        return temp

    def net_value(self):
        return round(float(self.value) - float(self.salary), 2)

    def __lt__(self, other):
        if self.net_value() < other.net_value():
            return True
        else:
            return False

class Branch:
#==========================================
# Purpose: creates an instantiation of the branch class
# Input Parameter(s):fname which is the name of a file
# Return Value(s): none
#==========================================
    def __init__(self, fname):
        with open(fname) as file:
            temp = file.readlines()
            x = temp[0].split(",")
            self.location = x[1]
            x = temp[1].split(",")
            self.upkeep = x[1]
            employees = []
            for i in range(3,len(temp)):
                temployee = Employee(temp[i])
                employees.append(temployee)

            self.team = employees


    def __str__(self):
        temp = self.location
        for i in range(len(self.team)):
            temp += "\n" + str(self.team[i])

        return temp

#==========================================
# Purpose: gets the profit of each branch
# Input Parameter(s): none
# Return Value(s): returns the profit of the branch
#==========================================
    def profit(self):
        tprofit = 0
        for i in range(len(self.team)):
            tprofit += self.team[i].net_value()
        tprofit -= float(self.upkeep)
        return tprofit

    def __lt__(self,other):
        if self.profit() < other.profit():
            return True
        else:
            return False

    def cut(self,num):
        for i in range(num):
            self.team.sort()
            self.team.pop(0)

class Company:
    def __init__(self,n,br):
        self.name = n
        self.branches = br
#==========================================
# Purpose: returns a string represenation of the company
# Input Parameter(s): none
# Return Value(s): returns a string represenation of the company
#==========================================
    def __str__(self):
        temp = self.name
        for i in range(len(self.branches)):
            temp += "\n"
            temp += "\n" + str(self.branches[i])
            
        return temp
#==========================================
# Purpose: finds the lowest profit branch and cuts it in half based on the lowest providing employees
# Input Parameter(s): none
# Return Value(s): none
#==========================================
    def synergize(self):
        worst = 0
        for i in range(len(self.branches) - 1):
            if self.branches[i] < self.branches[i + 1]:
                worst = self.branches[i]
        worst.cut(int(len(worst.team) / 2))

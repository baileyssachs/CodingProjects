/**
 * Written by Bailey Sachs
 * x500: Sachs096
 */
public class Quadratic
{
    private float a;
    private float b;
    private float c;

    /**
     * Constructor for the random class
     * @param float a: coefficient for x^2
     * @param float b: coefficient for x
     * @param float c: coefficient for x^0
     */
    public Quadratic(float a, float b, float c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * adds two Quadratics together and returns the result as a new quadratic
     * @param Quadratic other: the quadratic that you are adding to the current quadratic
     * @return Quadratic: new Quadratic that is current and other added together
     */
    public Quadratic add(Quadratic other)
    {
        float x = a + other.a;
        float y = b + other.b;
        float z = c + other.c;
        return new Quadratic(x,y,z);
    }

    /**
     * subtracts two Quadratics and returns the result as a new Quadratic
     * @param Quadratic other: the quadratic that you are subtracting from the current quadratic
     * @return Quadratic: new Quadratic that is current and other subtracted
     */
    public Quadratic subtract(Quadratic other)
    {
        float x = a - other.a;
        float y = b - other.b;
        float z = c - other.c;
        return new Quadratic(x,y,z);
    }

    /**
     * finds the roots of the Quadratic using the Quadtic forumula
     * @return Roots: an instance of the Roots class with the two root answers saved as Complex4 objects inside it
     */
    public Roots findRoots()
    {
        Roots temp = new Roots(new Quadratic(a,b,c));
        temp.findRoots();
        return temp;
    }

    /**
     * returns the a coefficient
     * @return float: returns the coefficient for x^2
     */
    public float getA()
    {
        return a;
    }

    /**
     * returns the b coefficient
     * @return float: returns the coefficient for x
     */
    public float getB()
    {
        return b;
    }
    
    /**
     * returns the c coefficient
     * @return float: returns the coefficient for x^0
     */
    public float getC()
    {
        return c;
    }

    /**
     * returns a string representation of Quadratic
     * @return String: quadratic equation with coefficnts in it.
     */
    public String toString()
    {
        float roundedA = Math.round(a * 10000.0) / (float)10000.0;
        float roundedB = Math.round(b * 10000.0) / (float)10000.0;
        float roundedC = Math.round(c * 10000.0) / (float)10000.0;
        if(b >= 0)
        {
            if(c >= 0)
            {
                String holder = roundedA + "x² + " + roundedB + "x + " + roundedC;
                return holder;
            }
            else
            {
                String holder = roundedA + "x² + " + roundedB + "x - " + (roundedC*-1);
                return holder;
            }
        }
        else
        {
            if(c >= 0)
            {
                String holder = roundedA + "x² - " + (roundedB*-1) + "x + " + roundedC;
                return holder;
            }
            else
            {
                String holder = roundedA + "x² - " + (roundedB*-1) + "x - " + (roundedC*-1);
                return holder;
            }
        }

    }

    /**
     * Tests if two Quadratics are equal to each other
     * @param Object other: other quadratic we are comparing to this one
     * @return boolean: returns true if the coefficients are equal to 4 decimal places
     */
    public boolean equals(Object other)
    {
        Quadratic temp = (Quadratic)other;
        float roundedA = Math.round(a * 10000.0) / (float)10000.0;
        float roundedOtherA = Math.round(temp.a * 10000.0) / (float)10000.0;
        float roundedB = Math.round(b * 10000.0) / (float)10000.0;
        float roundedOtherB = Math.round(temp.b * 10000.0) / (float)10000.0;
        float roundedC = Math.round(c * 10000.0) / (float)10000.0;
        float roundedOtherC = Math.round(temp.c * 10000.0) / (float)10000.0;
        if(roundedA == roundedOtherA && roundedB == roundedOtherB && roundedC == roundedOtherC)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //got answers to simple quadratic equations from this website because I am bad at math and wanted to confirm: https://www.mathsisfun.com/algebra/quadratic-equation.html
    public static void main(String[] args)
    {
        System.out.println("Comparing two quadratics with equal coefficients to 4 digits. Should be true: ");
        Quadratic a = new Quadratic((float)1.0324, (float)15.4214, (float)-9.0297);
        Quadratic b = new Quadratic((float)1.0324, (float)15.4214, (float)-9.0297);
        System.out.println(a.equals(b));
        System.out.println("Comparing two quadratics with unequal coefficients. Should be False: ");
        Quadratic notA = new Quadratic((float)1.0324, (float)15.4214, (float)-9.0298);
        System.out.println(a.equals(notA));
        
        System.out.println("\nTesting that find roots gets the right answers: ");
        Quadratic c = new Quadratic((float)5, (float)6, (float)1);
        System.out.println("\nAnswers should be -0.2 or -1: " + c.findRoots());
        
        Quadratic d = new Quadratic((float)5, (float)2, (float)1);
        System.out.println("\nAnswers should be -0.2 + 0.4i or -0.2 - 0.4i: " + d.findRoots());
        
        Quadratic e = new Quadratic((float)1, (float)-4, (float)6.25);
        System.out.println("\nAnswers should be 2 + 1.5i or 2 - 1.5i: " + e.findRoots());
        
        System.out.println("\nTesting that add works: ");
        Quadratic f = new Quadratic((float)5, (float)3, (float)1);
        Quadratic g = new Quadratic((float)4, (float)-1, (float)6);
        System.out.println("Should print 9x^2 + 2x + 7: " + (f.add(g)));
        
        Quadratic h = new Quadratic((float)20, (float)8.1, (float)1.25);
        Quadratic i = new Quadratic((float)-25, (float)9.3, (float)6.50);
        System.out.println("Should print -5x^2 + 17.4x + 7.75: " + (h.add(i)));
        
        System.out.println("\nTesting that subtract works: ");
        System.out.println("Should print 1x^2 + 4x - 5: " + (f.subtract(g)));
        System.out.println("Should print 45x^2 - 1.2x - 5.25: " + (h.subtract(i)));
    }
}

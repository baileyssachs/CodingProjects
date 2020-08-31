import java.lang.Math;
/**
 * Written by Bailey Sachs
 * x500: Sachs096
 */
public class Roots
{
    private Quadratic quad;
    private Complex4 firstRoot;
    private Complex4 secondRoot;

    /**
     *  Constructor for the Roots class
     *  @param Quadratic a: quadratic equation that will be solved
     */
    public Roots(Quadratic a)
    {
        quad = a;
    }

    /**
     * Calculates the roots of the quadratic equation using the quadratic formula
     * stores the roots as Complex4 objects in variables named firstRoot and secondRoot
     */
    public void findRoots()
    {
        double underRoot = Math.pow(quad.getB(),2) - (4 * quad.getA() * quad.getC());

        if(underRoot > 0)
        {
            double firstR = ((quad.getB() * -1) + Math.sqrt(underRoot)) / (2 * quad.getA());
            double roundedFirst = Math.round(firstR * 100.0) / 100.0;
            firstRoot = new Complex4(roundedFirst, 0);
            double secondR = ((quad.getB() * -1) - Math.sqrt(underRoot)) / (2 * quad.getA());
            double roundedSecond = Math.round(secondR * 100.0) / 100.0;
            secondRoot = new Complex4(roundedSecond, 0);
        }
        else if(underRoot == 0)
        {
            double roots = (quad.getB() * -1) / (2 * quad.getA());
            double roundedRoots = Math.round(roots * 100.0) / 100.0;
            firstRoot = new Complex4(roundedRoots, 0);
            secondRoot = new Complex4(roundedRoots, 0);
        }
        else
        {
            double real = (quad.getB() * -1) / (2 * quad.getA());
            double roundedReal = Math.round(real * 100.0) / 100.0;
            double imag = Math.sqrt(underRoot * -1) / (2 * quad.getA());
            double roundedImag = Math.round(imag * 100.0) / 100.0;
            firstRoot = new Complex4(roundedReal, roundedImag);
            secondRoot = new Complex4(roundedReal, (roundedImag * -1));
        }
    }

    /**
     * returns the first answer to the quadratic equation
     * @return Complex4: first root of the quadratic equation as a complex number
     */
    public Complex4 getFirstRoot()
    {
        return firstRoot;
    }

    /**
     * returns the second answer to the quadratic equation
     * @return Complex4: second root of the quadratic equation as a complex number
     */
    public Complex4 getSecondRoot()
    {
        return secondRoot;
    }

    /**
     * returns a string representation of the answer to the quadratic equation
     * @return String: both the first root and the second root which are solutions to the quadratic equation
     */
    public String toString()
    {
        String holder = "First root: " + firstRoot.toString() + ", second root: " + secondRoot.toString();
        return holder;
    }

    //Finished the testing of this in the Quadratic main meathod.
    public static void main(String[] args)
    {
        Roots temp = new Roots(new Quadratic((float)5, (float)6, (float)1));
        temp.findRoots();
        System.out.println(temp);
        System.out.println("Finished the testing of this in the Quadratic main meathod.");
    }
}

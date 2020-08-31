/**
 * Written by Bailey Sachs
 * x500: Sachs096
 */
public class Random
{
    private int seed;
    private int p1;
    private int p2;
    private int m;
    private int rOld = -1;

    /**
     * Constructor for the random class
     * @param int p1: large constant prime number
     * @param int p2: large constant prime number
     * @param int m: largest constant prime number; the maximum possible number
     */
    public Random(int p1, int p2, int m)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.m = m;
        seed = 1000;
    }

    /**
     * sets the seed to a certain int
     * @param int seed: seed for the random generator to use
     */
    public void setSeed(int seed)
    {
        this.seed = seed;
    }

    /**
     * Gets the maximum possible random number
     * @return int: maximum possible number that can be made
     */
    public int getMaximum()
    {
        return m;
    }

    /**
     * Generates a random int smaller than m
     * uses the formula: rNew = ((p1 * rOld) + p2) % m
     * uses seed for the first run but after that just uses the rOld.
     * @return int: a random number smaller than m
     */
    public int random()
    {
        int rNew = 0;
        if(rOld == -1)
        {
            rNew = ((p1 * seed) + p2) % m;
        }
        else
        {
            rNew = ((p1 * rOld) + p2) % m;
        }
        rOld = rNew;
        return rNew;
    }

    /**
     * generates a random int within a range
     * @param int lower: Lower bound
     * @param int upper: upper bound
     * @return int: an int within the range given
     */
    public int randomInteger(int lower, int upper)
    {

        if(lower > upper)
        {
            int holder = upper;
            upper = lower;
            lower = holder;
        }
        int x = random();
        int y = (upper-lower) + 1;
        int z = x % y;
        z += lower;
        return z;
    }
    
    /**
     * Generates a random boolean with a 50% chance of it being true and a 50% chance of it being false
     * @return boolean: a true or false with a 50% chance of being either
     */
    public boolean randomBoolean()
    {
        int x = random();
        if(x % 2 == 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Generates a random double within the given bounds
     * @param double lower: lower bound
     * @param double upper: upper bound
     * @return double: a random double within the range given
     */
    public double randomDouble(double lower, double upper)
    {
        if(lower > upper)
        {
            double holder = upper;
            upper = lower;
            lower = holder;
        }
        double x = random();
        double y = m / (upper - lower);
        double z = x / y;
        z += lower;
        double zRounded = Math.round(z * 100.0) / 100.0;
        return zRounded;
    }

    public static void main(String[] args)
    {

        Random test = new Random(7919,65537,102611);
        test.setSeed(12343);
        System.out.println("Random int hits lower bound: ");
        int lower = -1;
        while(lower != 1)
        {
            lower = test.randomInteger(1,5);
            if(lower == 1)
            {
                System.out.println("True\n");
            }
        }
        System.out.println("Random int hits upper bound: ");
        int upper = -1;
        while(upper != 5)
        {
            upper = test.randomInteger(1,5);
            if(upper == 5)
            {
                System.out.println("True\n");
            }
        }
        System.out.println("20 Random ints 1-20");
        for(int i = 0; i < 20; i++)
        {
            System.out.println(test.randomInteger(1,20));
        }
        System.out.println("\nNow 20 random ints from -50 - 50");
        for(int c = 0; c < 20; c++)
        {
            System.out.println(test.randomInteger(-50,50));
        }
        System.out.println("\nNow 20 ints from 100-250");
        for(int r = 0; r < 20; r++)
        {
            System.out.println(test.randomInteger(100,250));
        }
        System.out.println("\n20 random ints");
        for(int i = 0; i < 20; i++)
        {
            System.out.println(test.random());
        }
        System.out.println("\n5000 simulated true false results: ");
        int t = 0;
        int f = 0;
        for(int i = 0; i < 5000; i++)
        {
            Boolean y = test.randomBoolean();
            if(y == true)
            {
                t++;
            }
            else
            {
                f++;
            }
        }
        System.out.println("True: " + t + ", False: " + f);

        System.out.println("\nRandom double hits lower bound: ");
        double dLower = -1;
        while(dLower != 5.0)
        {
            dLower = test.randomDouble(5.0,10.0);
            if(dLower == 5.0)
            {
                System.out.println("True");
            }
        }
        System.out.println("\nRandom double hits upper bound: ");
        double dUpper = -1;
        while(dUpper != 10.0)
        {
            dUpper= test.randomDouble(5.0,10.0);
            if(dUpper == 10.0)
            {
                System.out.println("True");
            }
        }

        System.out.println("\n50 Doubles from -5.0 - 5.0");
        for(int i = 0; i < 50; i++)
        {
            System.out.println(test.randomDouble(-5.0,5.0));
        }
    }
}

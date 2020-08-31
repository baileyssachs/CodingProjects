import java.awt.*;
import java.util.*;

public class SandLab
{
    public static void main(String[] args)
    {
        SandLab lab = new SandLab(120, 80);
        lab.run();
    }

    //add constants for particle types here
    public static final int EMPTY = 0;
    public static final int METAL = 1;
    public static final int SAND = 2;
    public static final int WATER = 3;
    public static final int CLEAR = 4;
    public int count = 0;
    //do not add any more fields
    private int[][] grid;
    private SandDisplay display;

    public SandLab(int numRows, int numCols)
    {
        String[] names;
        names = new String[5];
        names[EMPTY] = "Empty";
        names[METAL] = "Metal";
        names[SAND] = "SAND";
        names[WATER] = "WATER";
        names[CLEAR] = "CLEAR";
        count = 0;
        grid = new int[numRows][numCols];
        display = new SandDisplay("Falling Sand", numRows, numCols, names);
    }

    //called when the user clicks on a location using the given tool
    private void locationClicked(int row, int col, int tool)
    {
        grid[row][col] = tool;
        if(tool == 4)
        {
            for(int r = 0; r < grid.length; r++)
            {
                for(int c = 0; c < grid[0].length;c++)
                {
                    grid[r][c] = 0;
                }
            }
        }
    }

    //copies each element of grid into the display
    public void updateDisplay()
    {
        for(int r = 0; r < grid.length; r++)
        {
            for(int c = 0; c < grid[0].length;c++)
            {
                if(grid[r][c] == 0)
                {
                    display.setColor(r,c, Color.BLACK);
                }
                if(grid[r][c] == 1)
                {
                    display.setColor(r,c, Color.GRAY);
                }
                if(grid[r][c] == 2)
                {
                    display.setColor(r,c, Color.YELLOW);
                }
                if(grid[r][c] == 3)
                {
                    display.setColor(r,c, Color.BLUE);
                }
                if(grid[r][c] == 5)
                {
                    display.setColor(r,c, Color.GREEN);
                }
            }
        }
    }

    //called repeatedly.
    //causes one random particle to maybe do something.
    public void step()
    {
        int temp1 =(int)(Math.random() * grid.length -1);
        int temp2 =(int)(Math.random() * grid[0].length - 1);
        if(grid[temp1][temp2] == 2 && grid[temp1 + 1][temp2] == 0)
        {
            grid[temp1 + 1][temp2] = 2;
            grid[temp1][temp2] = 0;

        }
        else if(grid[temp1][temp2] == 2 && grid[temp1 + 1][temp2] == 3)
        {
            grid[temp1 + 1][temp2] = 2;
            grid[temp1][temp2] = 3;
        }
        if(grid[temp1][temp2] == 3 && grid[temp1 + 1][temp2] == 0)
        {
            grid[temp1 + 1][temp2] = 3;
            grid[temp1][temp2] = 0;

        }
        else if(grid[temp1][temp2] == 3 && grid[temp1][temp2 + 1] == 0)
        {
            grid[temp1][temp2 + 1] = 3;
            grid[temp1][temp2] = 0;
        }
        else if(grid[temp1][temp2] == 3 && grid[temp1][temp2 - 1] == 0 && temp2 - 1 > 0)
        {
            grid[temp1][temp2 - 1] = 3;
            grid[temp1][temp2] = 0;
        }
        if(grid[temp1][temp2] == 3 && grid[temp1 + 1][temp2] == 3 && grid[temp1 - 1][temp2] == 3 && grid[temp1][temp2 + 1] == 3 && count < 5)
        {
            grid[temp1][temp2] = 5;
            
        }
        if(grid[temp1][temp2] == 5 && grid[temp1 + 1][temp2] == 3)
        {
            grid[temp1 + 1][temp2] = 5;
            grid[temp1][temp2] = 3;
        }
        else if(grid[temp1][temp2] == 5 && grid[temp1][temp2 + 1] == 3)
        {
            grid[temp1][temp2 + 1] = 5;
            grid[temp1][temp2] = 3;
        }
        else if(grid[temp1][temp2] == 5 && grid[temp1][temp2 - 1] == 3 && temp2 - 1 > 0)
        {
            grid[temp1][temp2 - 1] = 5;
            grid[temp1][temp2] = 3;
        }
        else if(grid[temp1][temp2] == 5 && grid[temp1 - 1][temp2] == 3 && temp1 - 1 > 0)
        {
            grid[temp1][temp2 + 1] = 5;
            grid[temp1][temp2] = 3;
        }
    }

    //do not modify
    public void run()
    {
        while (true)
        {
            for (int i = 0; i < display.getSpeed(); i++)
                step();
            updateDisplay();
            display.repaint();
            display.pause(1);  //wait for redrawing and for mouse
            int[] mouseLoc = display.getMouseLocation();
            if (mouseLoc != null)  //test if mouse clicked
                locationClicked(mouseLoc[0], mouseLoc[1], display.getTool());
        }
    }
}

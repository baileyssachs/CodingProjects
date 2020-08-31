/**
 * The model for John Conway's Game of Life.
 *
 * @author Rick Mercer
 *
 * This class has all needed methods as stubs. Comments explain each method.
 *
 */
public class GameOfLife {
    int numrows;
    int numcols;
    boolean[][] a;
    /**
     * Write the constructor so it takes two integer arguments to represent the
     * number of rows and columns in the game of life. The constructor creates a
     * society with no cells but space to store rows*cols cells.
     *
     * @param rows
     *            The height of the grid that shows the cells.
     * @param cols
     *            The width of the grid that shows the cells.
     */
    public GameOfLife(int rows, int cols) {
        numrows = rows;
        numcols = cols;
        a = new boolean[numrows][numcols];
    }

    /**
     * Return the number of rows, which can be indexed from 0..numberOfRows()-1.
     *
     * @return The height of the society.
     */
    public int numberOfRows() {
        return numrows;
    }

    /**
     * The number of columns, which can be indexed from 0..numberOfColumns()-1.
     *
     * @return The height of the society.
     */
    public int numberOfColumns() {
        return numcols;
    }

    /**
     * Place a new cell in the society. Precondition: row and col are in range.
     *
     * @param row
     *            The row to grow the cell.
     * @param col
     *            The column to grow the cell.
     */
    public void growCellAt(int row, int col) {
        a[row][col] = true;
    }

    /**
     * 5) Return true if there is a cell at the given row and column. Return
     * false if there is none at the specified location.
     *
     * @param row
     *            The row to check.
     * @param col
     *            The column to check.
     * @return True if there is a cell at the given row or false if none
     */
    public boolean cellAt(int row, int col) {
        if(a[row][col] == true)
        {
            return true;
        }
        return false;
    }

    /**
     * Return one big string of cells to represent the current state of the
     * society of cells (see output below where '.' represents an empty space
     * and 'O' is a live cell. There is no need to test toString. Simply use it
     * to visually inspect if needed. Here is one sample output from toString:
     *
     * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
     * society.growCellAt(2, 3); society.growCellAt(3, 4);
     * System.out.println(society.toString());
     *
     * Output .............. ..O........... ...O.......... ....O.........
     *
     * @return A textual representation of this society of cells.
     */
    @Override
    public String toString() {
        String temp = "";
        for(int i = 0; i < a.length; i++)
        {
            for(int c = 0; c < a[0].length; c++)
            {
                if(a[i][c] == false)
                {
                    temp += ".";
                }
                else
                {
                    temp += "0";
                }
            }
            temp += "\n";
        }
        return temp;
    }

    /**
     * Count the neighbors around the given location. Use wraparound. A cell in
     * row 0 has neighbors in the last row if a cell is in the same column, or
     * the column to the left or right. In this example, cell 0,5 has two
     * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
     * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
     * The potential location for a cell at 4,8 would have three neighbors.
     *
     * .....O..O
     * O........
     * O.......O
     * O.......O
     * ....O.O..
     *
     *
     * The return values should always be in the range of 0 through 8.
     *
     * @return The number of neighbors around any cell using wrap around.
     */
    public int neighborCount(int row, int col) {
        int count = 0;

        if(row != 0 && col != 0 && row != numrows-1 && col != numcols-1)
        {
            int[][] surrounding = {{row - 1, col - 1},{row - 1, col    },{row - 1, col + 1},
                    {row    , col - 1},{row    , col + 1},{row + 1, col - 1},{row + 1, col    },
                    {row + 1, col + 1}};

            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == 0 && col != 0 && col != numcols-1)
        {
            int[][] surrounding = {{numrows-1, col - 1},{numrows-1, col    },{numrows-1, col + 1},
                    {row    , col - 1},{row    , col + 1},{row + 1, col - 1},{row + 1, col    },
                    {row + 1, col + 1}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == numrows-1 && col != 0 && col != numcols-1)
        {
            int[][] surrounding = {{row - 1, col - 1},{row - 1, col    },{row - 1, col + 1},
                    {row    , col - 1},{row    , col + 1},{0, col - 1},{0, col    },
                    {0, col + 1}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row != 0 && row != numrows - 1 && col == 0)
        {
            int[][] surrounding = {{row - 1, numcols-1},{row - 1, col    },{row - 1, col + 1},
                    {row    , numcols - 1},{row    , col + 1},{row + 1, numcols-1},{row + 1, col    },
                    {row + 1, col + 1}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row != 0 && row != numrows - 1 && col == numcols - 1)
        {
            int[][] surrounding = {{row - 1, col - 1},{row - 1, col    },{row - 1,0},
                    {row    , col - 1},{row    , 0},{row + 1, col - 1},{row + 1, col    },
                    {row + 1, 0}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == 0 && col == 0)
        {
            int[][] surrounding = {{numrows - 1, numcols - 1},{numrows - 1, col    },{numrows - 1, col + 1},
                    {row    , numcols - 1},{row    , col + 1},{row + 1, numcols - 1},{row + 1, col    },
                    {row + 1, col + 1}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == numrows -1 && col == numcols - 1)
        {
            int[][] surrounding = {{row - 1, col - 1},{row - 1, col    },{row - 1, 0},
                    {row    , col - 1},{row    , 0},{0, col - 1},{0, col    },
                    {0, 0}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == 0 && col == numcols - 1)
        {
            int[][] surrounding = {{numrows - 1, col - 1},{numrows - 1, col    },{numrows - 1, 0},
                    {row    , col - 1},{row    , 0},{row + 1, col - 1},{row + 1, col    },
                    {row + 1, 0}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }
        else if(row == numrows - 1 && col == 0)
        {
            int[][] surrounding = {{row - 1, numcols - 1},{row - 1, col    },{row - 1, col + 1},
                    {row    , numcols - 1},{row    , col + 1},{0, numcols - 1},{0, col    },
                    {0, col + 1}};
            for (int i[]: surrounding) {
                if (a[i[0]][i[1]] == true) {
                    count++;

                }
            }
        }

        return count;

    }

    /**
     * Update the state to represent the next society. Typically, some cells
     * will die off while others are born.
     */
    public void update() {
        boolean[][] temp = new boolean[numrows][numcols];
        for(int i = 0; i < temp.length; i++)
        {
            for(int b = 0; b < temp[0].length; b++)
            {
                if(a[i][b] == true)
                {
                    temp[i][b] = true;
                }
            }
        }
        for(int r = 0; r < temp.length; r++)
        {
            for(int c = 0; c < temp[0].length;c++)
            {
                if(neighborCount(r,c) == 3)
                {
                    temp[r][c] = true;
                }
                else if(neighborCount(r,c) < 2)
                {
                    temp[r][c] = false;
                }
                else if(neighborCount(r,c) > 3)
                {
                    temp[r][c] = false;
                }
            }
        }
        a = temp;
    }
}

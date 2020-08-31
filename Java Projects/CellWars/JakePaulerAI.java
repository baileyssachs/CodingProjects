
/**
 * JakePaulerAI.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class JakePaulerAI extends CellAI
{
    @Override
    public String getAIName() {
        return "JakePaulerAI";
    }

    @Override
    public Location select(Grid grid) {
        GridFunctions temp = new GridFunctions();
        int count = 0;
        //gets how many of my cells are left
        for(int r = 0; r < grid.getRows(); r++) {
            for(int c = 0; c < grid.getCols(); c++) {
                if(grid.getCell(r,c) != -1 && grid.getCell(r,c) == getID()) {
                    count++;
                }
            }
        }
        if(count <= 30)
        {
            //rebuilds the 1 cells so they dont die
            for(int r = 0; r < grid.getRows(); r++) {
                for(int c = 0; c < grid.getCols(); c++) {
                    if ((GridFunctions.getNeighbors(r, c, grid) == 1) && (grid.getCell(r, c) == getID()) && (grid.getCell(r,c) != -1)) {
                        if ((r + 1 < grid.getRows()) && (grid.getCell(r + 1, c) == -1))
                            return new Location(r + 1, c);
                        if ((c + 1 < grid.getCols()) && (grid.getCell(r, c + 1) == -1))
                            return new Location(r, c + 1);
                        if ((r > 0) && (grid.getCell(r - 1, c) == -1))
                            return new Location(r - 1, c);
                        if ((c > 0) && (grid.getCell(r, c - 1) == -1))
                            return new Location(r, c - 1); 
                    }
                }
            }
            //rebuilds the groups of 2's into 3's so they can rebuild and keep expanding
            for(int r = 0; r < grid.getRows(); r++) {
                for(int c = 0; c < grid.getCols(); c++) {
                    if ((temp.getNeighbors(r, c, grid) == 2) && (grid.getCell(r, c) == getID()) && (grid.getCell(r,c) != -1)) {
                        if ((r + 1 < grid.getRows()) && (grid.getCell(r + 1, c) == -1))
                            return new Location(r + 1, c);
                        if ((c + 1 < grid.getCols()) && (grid.getCell(r, c + 1) == -1))                      
                            return new Location(r, c + 1);
                        if ((r > 0) && (grid.getCell(r - 1, c) == -1))
                            return new Location(r - 1, c);
                        if ((c > 0) && (grid.getCell(r, c - 1) == -1)) 
                            return new Location(r, c - 1); 
                    }
                }
            }
        }
        //lawn mower attack but for vital points(has 2 neighbors) so the enemies fall apart more efficently
        for(int r = 0; r < grid.getRows(); r++) {
            for(int c = 0; c < grid.getCols(); c++) {
                if(grid.getCell(r,c) != -1 && grid.getCell(r,c) != getID() && temp.getNeighbors(r,c,grid) == 2) {
                    return new Location(r, c);
                }
            }
        }
        //tries to get the "blocks" to break
        for(int x = 0; x < grid.getRows(); x++) {
            for(int y = 0; y < grid.getCols(); y++) {
                if(grid.getCell(x,y) != -1 && grid.getCell(x,y) != getID() && temp.getNeighbors(x,y,grid) == 3)
                {
                    if((x + 1 <= grid.getCols()) && (grid.getCell(x + 1 ,y) == -1))
                        return new Location(x + 1, y);
                    if((y + 1 < grid.getRows()) && (grid.getCell(x ,y + 1) == -1))
                        return new Location(x, y + 1);
                    if((x-1 >= 0) && (grid.getCell(x - 1 ,y) == -1 ))
                        return new Location(x - 1, y);
                    if((y-1 >= 0) && (grid.getCell(x ,y - 1) == -1))
                        return new Location(x, y - 1);
                }
            }
        }
        //this should never happen but i needed it to compile
        return new Location(0,0);
    }
}

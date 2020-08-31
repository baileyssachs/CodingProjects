import static org.junit.Assert.*; 
import org.junit.Test;
public class GameOfLifeTest {

    @Test
    public void testConstructorAndGetters() 
    { 
        GameOfLife society = new GameOfLife(5, 8); 
        assertEquals(5, society.numberOfRows()); 
        assertEquals(8, society.numberOfColumns());
        for (int r = 0; r < society.numberOfRows(); r++)
            for (int c = 0; c < society.numberOfColumns(); c++) 
                assertFalse(society.cellAt(r, c));
    }

    @Test
    public void testGrowCellAtAndCellAt() 
    { 
        GameOfLife society = new GameOfLife(4, 4); 
        society.growCellAt(1, 1); 
        society.growCellAt(2, 2); 
        society.growCellAt(3, 3);
        assertTrue(society.cellAt(1, 1)); 
        assertTrue(society.cellAt(2, 2)); 
        assertTrue(society.cellAt(3, 3));
    }

    @Test
    public void testNeighborsWrapping() 
    { 
        GameOfLife society = new GameOfLife(10, 16); 
        society.growCellAt(3, 3); 
        society.growCellAt(3, 4); 
        society.growCellAt(3, 5);
        assertEquals(0, society.neighborCount(2, 1)); 
        assertEquals(1, society.neighborCount(2, 2)); 
        assertEquals(2, society.neighborCount(2, 3)); 
        assertEquals(3, society.neighborCount(2, 4)); 
        // ... many more assertions expected
    }

    @Test
    public void testNeighborCount()
    {
        GameOfLife a = new GameOfLife(8,8);
        a.growCellAt(4,6);
        a.growCellAt(4,7);
        a.growCellAt(7,7);
        a.growCellAt(4,0);
        a.growCellAt(0,0);
        a.growCellAt(0,7);
        a.growCellAt(7,0);
        a.growCellAt(2,2);
        a.growCellAt(2,3);
        a.growCellAt(2,1);
        a.growCellAt(3,3);
        assertEquals(0, a.neighborCount(6,4));
        assertEquals(3, a.neighborCount(0,0));
        assertEquals(3, a.neighborCount(2,2));
        assertEquals(1, a.neighborCount(4,0));
    }

    @Test
    public void testUpdate() {
        GameOfLife society = new GameOfLife(10, 10);
        society.growCellAt(0, 0);
        society.growCellAt(1, 1);
        society.growCellAt(1, 2);
        society.growCellAt(2, 0);
        society.growCellAt(2, 1);

        society.update();
        assertFalse(society.cellAt(0, 0));
        assertTrue(society.cellAt(0, 1));
        assertFalse(society.cellAt(0, 2));
        assertFalse(society.cellAt(0, 3));
        assertFalse(society.cellAt(1, 1));
        assertTrue(society.cellAt(1, 2));
        assertFalse(society.cellAt(1, 3));
        assertTrue(society.cellAt(2, 0));
        assertTrue(society.cellAt(2, 1));
        assertTrue(society.cellAt(2, 2));
        assertFalse(society.cellAt(2, 3));

    }

    // ... Add many more @Test methods here
}
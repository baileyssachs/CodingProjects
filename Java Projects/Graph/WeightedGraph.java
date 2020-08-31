import java.util.ArrayDeque;
/**
 * Write a description of class WeightedGraph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class WeightedGraph<T> implements WeightedGraphInterface<T>
{
    public static final int NULL_EDGE = 0;
    private static final int DEFCAP = 50;
    private int numVertices;  
    private int maxVertices; 
    private T[] vertices; 
    private int[][] edges; 
    private boolean[] marks;
    @SuppressWarnings("unchecked")    
    public WeightedGraph(int maxV)
    {        numVertices = 0; 
        maxVertices = maxV;  
        vertices = (T[]) new Object[maxV]; 
        marks = new boolean[maxV];     
        edges = new int[maxV][maxV];  
    }

    public WeightedGraph()    {  
        this(DEFCAP);  
    }

    public boolean empty()
    {
        for(int i = 0; i < vertices.length; i++)
        {
            if(vertices[i] != null)
            {
                return false;
            }
        }
        return true;
    }

    // tests if graph is full
    public boolean full()
    {
        for(int i = 0; i < vertices.length; i++)        
        {
            if(vertices[i] == null)
            {
                return false;
            }
        }
        return true;
    }

    // Precondition: Vertex is not already in graph
    // Precondition: Vertex is not null
    // adds vertex to graph
    public void addVertex(T vertex)
    {
        vertices[numVertices] = vertex;
        for(int i = 0; i < numVertices; i++)
        {
            edges[numVertices][i] = NULL_EDGE;
            edges[i][numVertices] = NULL_EDGE;
        }
        numVertices++;
    }

    public int findIndex(T vertex)
    {
        for(int i = 0; i < vertices.length; i++)
        {
            if(vertices[i].equals(vertex))
            {
                return i;   
            }
        }
        return -1;
    }

    // returns true if graph contains vertex
    public boolean hasVertex(T vertex)
    {
        if(findIndex(vertex) == -1)
        {
            return false;
        }
        return true;
    }

    // adds an edge with the specified weight from fromVertex to toVertex
    public void setEdge(T fromVertex, T toVertex,int weight)
    {
        int row = findIndex(fromVertex);
        int col = findIndex(toVertex);
        edges[row][col] = weight;
    }

    // if edge from fromVertex to toVertex exists, return the weight of
    // the edge; otherwise, returns a special "null-edge" value.
    public int weightIs(T fromVertex, T toVertex)
    {
        if(edges[findIndex(fromVertex)][findIndex(toVertex)] != 0)
        {
            return edges[findIndex(fromVertex)][findIndex(toVertex)];
        }
        else
        {
            return 0;
        }
    }

    // returns a queue of the vertices that are adjacent to the vertex
    public QueueInterface<T> getAdjacentVertices(T vertex)
    {
        int fromIndex = findIndex(vertex);
        LinkedQueue a = new LinkedQueue();
        for(int i = 0; i < numVertices; i++)
        {
            if(edges[fromIndex][i] != 0)
            {
                a.add(vertices[i]);
            }
        }
        return a;
    }

    // sets marks for all vertices to false
    public void clearMarks()
    {
        for(int i = 0; i < marks.length; i++)
        {
            marks[i] = false;
        }   
    }

    // sets mark for vertex to true
    public void markVertex(T vertex)
    {
        int temp = findIndex(vertex);
        marks[temp] = true;
    }

    // returns true if vertex is marked
    public boolean isMarked(T vertex)
    {
        int temp = findIndex(vertex);
        if(marks[temp] == true)
        {
            return true;
        }
        return false;
    }

    // returns an unmarked vertex if any exist, otherwise returns null
    public T getUnmarked()
    {
        for(int i = 0; i < marks.length; i++)
        {
            if(marks[i] == false)
            {
                return vertices[i];
            }   
        }
        return null;
    }

    // return a String representation of this graph
    public String toString()
    {
        String result = "\nGraph representation:\n\t";        
        for(int i = 0; i < vertices.length; i++)
            if(vertices[i] != null)                
                result += ((String)vertices[i]).substring(0, 3) + "\t";
        result += "\n";        
        for(int r = 0; r < vertices.length; r++)            
            if(vertices[r] != null)            
            {               
                result += ((String)vertices[r]).substring(0, 3) + "\t";                
                for(int c = 0; c < vertices.length; c++)                
                {                    if(vertices[c] != null)                        
                        result += edges[r][c] + "\t";                
                }                result += "\n";        }        
        return result;
    }
}

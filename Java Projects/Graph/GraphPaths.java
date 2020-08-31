import java.util.Stack;
import java.util.PriorityQueue;
public class GraphPaths
{
    public static boolean isPathDF(WeightedGraphInterface<String> graph, 
    String startVertex, String endVertex)
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses depth-first search algorithm.
    {
        WeightedGraphInterface g = graph;
        boolean found = false;
        Stack a = new Stack();
        g.clearMarks();
        a.push(startVertex);
        String abc;
        while(a.isEmpty() == false && found == false)
        {
            abc = (String)a.pop();
            if(abc.equals(endVertex))
            {
                found = true;
            }
            else
            {
                if(g.isMarked(abc) == false)
                {
                    g.markVertex(abc);

                    QueueInterface temp = graph.getAdjacentVertices(abc); 
                    while(!temp.empty())
                    {
                        a.push(temp.remove());
                    }
                }
            }
        }
        return found;
    }

    public static boolean isPathBF(WeightedGraphInterface<String> graph, 
    String startVertex, String endVertex    )
    // Returns true if a path exists on graph, from startVertex to endVertex; 
    // otherwise returns false. Uses breadth-first search algorithm.
    {
        WeightedGraphInterface g = graph;
        boolean found = false;
        LinkedQueue a = new LinkedQueue();
        g.clearMarks();
        a.add(startVertex);
        String abc;
        while(a.empty() == false && found == false)
        {
            abc = (String)a.remove();
            if(abc.equals(endVertex))
            {
                found = true;
            }
            else
            {
                if(g.isMarked(abc) == false)
                {
                    g.markVertex(abc);

                    QueueInterface temp = graph.getAdjacentVertices(abc); 
                    while(!temp.empty())
                    {
                        a.add(temp.remove());
                    }
                }
            }
        }
        return found;
    }

    public static QueueInterface<Flight> shortestPaths(WeightedGraphInterface<String> graph, 
    String startVertex)
    //Determines the shortest distance from startVertex to every other reachable vertex in graph.
    {
         WeightedGraphInterface g = graph;
        g.clearMarks();
        QueueInterface rq = new LinkedQueue();
        QueueInterface vq = new LinkedQueue();
        PriorityQueue pq = new PriorityQueue();
        Flight f = new Flight(startVertex, startVertex, 0);
        pq.add(f);

        
        while(!pq.isEmpty()){
            f = (Flight)pq.remove();
            if(!g.isMarked(f.getToVertex())){
                g.markVertex(f.getToVertex());
                rq.add(f);
                f.setFromVertex(f.getToVertex());
                int minDistance = f.getDistance();
                vq = g.getAdjacentVertices(f.getFromVertex());
                while(!vq.empty()){
                    String vertex = (String)vq.remove();
                    if(!g.isMarked(vertex)){
                        int newDistance = minDistance + graph.weightIs(f.getFromVertex(), vertex);
                        Flight newFlight = new Flight(f.getFromVertex(), vertex, newDistance);
                        pq.add(newFlight);
                    }

                }
            }

        }

        return rq;
    }

}
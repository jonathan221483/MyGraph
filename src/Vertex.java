import java.util.HashMap;
import java.util.Map;
public class Vertex<O> {
    private O data;
    private Map<Vertex<O>, Double> adjacentVertices;
    public void addAdjacentVertex(Vertex<O> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }

}
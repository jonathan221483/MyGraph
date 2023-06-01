import java.util.HashMap;
import java.util.Map;
public class Vertex<O> {
    private O data;
    private Map<Vertex<O>, Double> adjacentVertices;
    public Vertex(O data) { //constructor for vertex
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    public void validateVertex(Vertex<O> vertex) { //check if index is correct
        if (!adjacentVertices.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex.toStr() + " is out of the range");
        }
    }
    public void addVertex(Vertex<O> dest, double weight) {
        adjacentVertices.put(dest, weight);
    } //add vertex to graph
    public void removeVertex(Vertex<O> vertex) { //remove vertex from graph
        validateVertex(vertex);
        adjacentVertices.remove(vertex);
    }
    public void clearVertices(Vertex<O> vertex) {
        adjacentVertices.clear();
    } //delete all vertices
    public double getWeight(Vertex<O> vertex) {
        validateVertex(vertex);
        return adjacentVertices.get(vertex);
    }

    public O toStr() {
        return data;
    } //needed to print vertex data as a string
}
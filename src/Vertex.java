import java.util.HashMap;
import java.util.Map;
public class Vertex<O> {
    private O data;
    private Map<Vertex<O>, Double> adjacentVertices;
    public Vertex(O data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    public void validateVertex(Vertex<O> vertex) {
        if (!adjacentVertices.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex.toStr() + " is out of the range");
        }
    }
    public void addVertex(Vertex<O> dest, double weight) {
        adjacentVertices.put(dest, weight);
    }
    public void removeVertex(Vertex<O> vertex) {
        validateVertex(vertex);
        adjacentVertices.remove(vertex);
    }
    public void clearVertices(Vertex<O> vertex) {
        adjacentVertices.clear();
    }
    public double getWeight(Vertex<O> vertex) {
        validateVertex(vertex);
        return adjacentVertices.get(vertex);
    }

    public boolean contains(Vertex<O> vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public O toStr() {
        return data;
    }

}
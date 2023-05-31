import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WeightedGraph<O> {
    private Map<Vertex<O>, List<Edge<O>>> vertices;
    public WeightedGraph() {
        vertices = new HashMap<>();
    }
    public class Edge<O> {
        private Vertex<O> source;
        private Vertex<O> dest;
        private double weight;
        public Edge(Vertex<O> source, Vertex<O> dest, double weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
        public Vertex<O> getSource() {
            return source;
        }
        public Vertex<O> getDestination() {
            return dest;
        }
        public double getWeight() {
            return weight;
        }
    }

    private void validateVertex(Vertex index) {
        if (!vertices.containsKey(index)) {
            throw new IllegalArgumentException("Vertex " + index + " is out of the range");
        }
    }
    public void addVertex(Vertex<O> vertex) {
        vertices.put(vertex, new LinkedList<>());
    }
    public void addEdge(Vertex source, Vertex dest, double weight){
        validateVertex(source);
        validateVertex(dest);
        List<Edge<O>> edge = vertices.get(source);
        edge.add(new Edge<O>(source, dest, weight));
        vertices.put(source, edge);
    }
    public List<Edge<O>> getEdge(Vertex<O> vertex) {
        validateVertex(vertex);
        return vertices.get(vertex);
    }


    public void printGraph() {
        System.out.println("Source | Destination | Weight");
        for (List<Edge<O>> edges : vertices.values()) {
            for (Edge<O> edge : edges) {
                System.out.println(edge.getSource().toStr() + "      |      " + edge.getDestination().toStr() + "      |   " + edge.getWeight());
            }
        }
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>();
        Vertex<Integer> a = new Vertex<>(1);
        Vertex<Integer> b = new Vertex<>(2);
        Vertex<Integer> c = new Vertex<>(3);
        Vertex<Integer> d = new Vertex<>(4);
        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addEdge(a,d,6);
        graph.addEdge(a,c,14);
        graph.addEdge(c,d,2);
        graph.addEdge(b,d,8);
        graph.addEdge(b,c,4);
        graph.addEdge(a,b,23);
        graph.printGraph();
        graph.removeVertex(a);
        graph.printGraph();
        Search<Integer> bfs = new BFS<>(graph);
        List<Integer> bfsPath = bfs.search(b, c);
        System.out.println("Breadth-First Search Path: " + bfsPath);

    }
}

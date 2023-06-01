import java.util.*;
public class Main {
    public static void main(String[] args) {
        WeightedGraph<Integer> graph = new WeightedGraph<>(); //create instance of class Weighted graph
        Vertex<Integer> a = new Vertex<>(1); //create vertices
        Vertex<Integer> b = new Vertex<>(2);
        Vertex<Integer> c = new Vertex<>(3);
        Vertex<Integer> d = new Vertex<>(4);
        graph.addVertex(a); //add vertices into graph
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addEdge(a,d,6); //connect these vertices with edges
        graph.addEdge(a,c,14);
        graph.addEdge(c,d,2);
        graph.addEdge(b,d,8);
        graph.addEdge(b,c,4);
        graph.addEdge(a,b,23);
        graph.printGraph(); //print all information from graph
        graph.removeVertex(a); //remove vertex "a" from graph
        graph.printGraph();
        Search<Integer> bfs = new BFS<>(graph); //create instance of bfs class
        List<Integer> bfsPath = bfs.search(d, c); //make a path between vertices d and c using bfs
        System.out.println("Breadth-First Search Path: " + bfsPath); //output the path
    }
}

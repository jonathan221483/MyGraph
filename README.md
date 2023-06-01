# Algorithms and Data Structures | Khaimuldin Nursultan
## Assignment 6 | Graph implementation
### Classes needed to be implemented:

## Vertex class

```
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
```



## Weighted graph class

```
public class Edge<O> {
        private Vertex<O> source;
        private Vertex<O> dest;
        private double weight;
        public Edge(Vertex<O> source, Vertex<O> dest, double weight) { //constructor for edge
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
        public Vertex<O> getSource() {
            return source;
        } //getters for edge class
        public Vertex<O> getDestination() {
            return dest;
        }
        public double getWeight() {
            return weight;
        }
    }

    private void validateVertex(Vertex vertex) { //check if vertex exist in graph
        if (!vertices.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex " + vertex.toStr() + " is out of the range");
        }
    }
    public void addVertex(Vertex<O> vertex) {
        vertices.put(vertex, new LinkedList<>());
    } //add vertex into graph
    public void removeVertex(Vertex<O> vertex) {
        vertices.remove(vertex);
    } //remove vertex from graph
    public void addEdge(Vertex source, Vertex dest, double weight){ //connect vertices with edge
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


    public void printGraph() { //print all information from graph
        System.out.println("Source | Destination | Weight");
        for (List<Edge<O>> edges : vertices.values()) {
            for (Edge<O> edge : edges) {
                System.out.println(edge.getSource().toStr() + "      |      " + edge.getDestination().toStr() + "      |   " + edge.getWeight());
            }
        }
    }
```

## Search interface
 ```
    public interface Search<O> { //interface needed to implement BFS and Dijkstra searchng algotithms
    List<O> search(Vertex<O> start, Vertex<O> finish);
}
 ```
  
## Main testing
 ```
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
 ```
  

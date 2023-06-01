import java.util.*;
public class BFS<O> implements Search<O>{
    private WeightedGraph<O> graph;
    public BFS(WeightedGraph<O> graph) {
        this.graph = graph;
    } //constructor for bfs
    @Override
    public List<O> search(Vertex<O> start, Vertex<O> finish) { //bfs algorithm overrides the search method from interface
        List<Vertex<O>> path = new ArrayList<>();
        Queue<Vertex<O>> queue = new LinkedList<>();
        Map<Vertex<O>, Vertex<O>> parentMap = new HashMap<>();

        queue.offer(start);
        parentMap.put(start, null);

        while (!queue.isEmpty()) { //
            Vertex<O> currentVertex = queue.poll();
            if (currentVertex.equals(finish)) {
                path.add(finish);
                Vertex<O> parent = parentMap.get(finish);
                while (parent != null) {
                    path.add(0, parent);
                    parent = parentMap.get(parent);
                }
                break;
            }
            List<WeightedGraph<O>.Edge<O>> edges = graph.getEdge(currentVertex);
            for (WeightedGraph<O>.Edge<O> edge : edges) {
                Vertex<O> neighborVertex = edge.getDestination();
                if (!parentMap.containsKey(neighborVertex)) {
                    queue.offer(neighborVertex);
                    parentMap.put(neighborVertex, currentVertex);
                }
            }
        }
        return (List<O>) path;
    }
}

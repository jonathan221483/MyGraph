import java.util.*;

public class DijkstraSearch<O> implements Search<O> {
    private WeightedGraph<O> graph;
    public DijkstraSearch(WeightedGraph<O> graph) {
        this.graph = graph;
    }
    @Override
    public List<O> search(Vertex<O> start, Vertex<O> finish) {
        return null;
    }
}

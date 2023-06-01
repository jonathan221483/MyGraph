import java.util.List;
public interface Search<O> { //interface needed to implement BFS and Dijkstra searchng algotithms
    List<O> search(Vertex<O> start, Vertex<O> finish);
}
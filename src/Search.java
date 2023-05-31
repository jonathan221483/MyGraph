import java.util.List;
public interface Search<O> {
    List<O> search(Vertex<O> start, Vertex<O> finish);
}
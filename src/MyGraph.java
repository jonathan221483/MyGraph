import java.util.LinkedList;
public class MyGraph{
    private int VertexNumber;
    private LinkedList<Integer>[] list;
    public MyGraph(int VertexNumber) {
        this.VertexNumber = VertexNumber;
        list = new LinkedList[VertexNumber];
        for(int i = 0; i < VertexNumber; i++)
        {
            list[i] = new LinkedList<>();
        }
    }
}

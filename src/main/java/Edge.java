/**
 * Edge class for Node and Graph
 * contains from, to, weight and color properties
 * @author Jialong Li
 *
 * */

public class Edge {
    public transient String from, to;
    public int weight;
    public String color;

    public Edge(String from, String to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
        this.color = "black";
    }
    public Edge(String from, String to){
        this(from, to, 1);
    }

    public void resetColor(String color) {
        this.color = "black";
    }
}

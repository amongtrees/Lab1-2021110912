import java.util.ArrayList;
import java.util.List;

public class Node {
    public String name;
    public String color;
    public List<Edge> edges = new ArrayList<>();

    /**
     * Init a Node with name, default color is black, just like Edge
     * @param name from the wordlist of transformed text
     */
    public Node(final String name){
        this.name = name;
        this.color = "black";
    }

    public void resetColor(){
        this.color = "black";
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getName(){
        return this.name;
    }

    public String getColor(){
        return this.color;
    }

    public void addOutEdge(Edge e){
        this.edges.add(e);
    }

    public List<Edge> getEdges(){
        return edges;
    }

    public Integer findEdgeIndex(String to){
        for (int i = 0; i < this.edges.size(); i++){
            if(this.edges.get(i).to.equals(to)){
                return i;
            }
        }
        return null;
    }

}

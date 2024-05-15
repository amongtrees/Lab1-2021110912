import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    public Graph(){}

    private Map<String, Node> nodes = new HashMap<>();

    /**
     * Add a node to the Graph with the node name, with the default color--black
     * @param name is the word from the transformed text
     */
    public void addNode(String name){
        Node n = new Node(name);
        this.nodes.put(name, n);
    }

    public void deleteNode(String name){
        this.nodes.remove(name);
    }

    public Integer findEdgeIndex(String from, String to){
        Node node = nodes.get(from);
        if (node == null)
            return null;
        else
            return node.findEdgeIndex(to);
    }

    public void addEdge(String from, String to, int weight){
        if (nodes.get(from) == null){
            this.addNode(from);
        }
        if (nodes.get(to) == null){
            this.addNode(to);
        }
        Integer index = findEdgeIndex(from, to);
        if (index != null){
            nodes.get(from).edges.get(index).weight += weight;
        }
        else
            nodes.get(from).addOutEdge(new Edge(from, to, weight));
    }

    public void addEdge(String from, String to){
        addEdge(from, to, 1);
    }

    public Node getNode(String name){
        return nodes.get(name);
    }

    public List<Node> getNodeList(){
        List<Node> nodeList = new ArrayList<>();
        for (Node node : nodes.values())
            nodeList.add(node);
        return nodeList;
    }

}

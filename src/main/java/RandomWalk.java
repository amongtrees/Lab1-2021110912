import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomWalk {
    static Set<String> Edges;
    static Graph tmpG;
    public static String randomWalk(Graph graph, String outputFile){
        tmpG = graph;
        Edges = new HashSet<>();
        List<Node> tmpNodes = tmpG.getNodeList();
        int range = tmpNodes.size();
        int startIndex = new Random().nextInt(range);
        Node startNode = tmpNodes.get(startIndex);
        StringBuilder S = new StringBuilder();
        S.append(startNode.name);
        List<Edge> tmpEdges = startNode.getEdges();
        while (!tmpEdges.isEmpty()){
            range = tmpEdges.size();
            startIndex = new Random().nextInt(range);
            Edge tmpE = tmpEdges.get(startIndex);
            if (Edges.contains(tmpE.from + tmpE.to)){
                S.append(" ").append(tmpE.to);
                break;
            }
            else {
                Edges.add(tmpE.from + tmpE.to);
                Node nextNode = tmpG.getNode(tmpE.to);
                S.append(" ").append(tmpE.to);
                tmpEdges = nextNode.getEdges();
            }

        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(S.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return S.toString();
    }
}

import java.util.Set;

public class Main {

    /**
     * a function that shows the directed graph
     * param
     */
    void showDirectedGraph(Graph G){

    }
    String queryBridgeWords(String word1, String word2){
        return "";
    }

    String generateNewText(String inputText){
        return "";
    }

    String calcShortestPath(String word1, String word2){
        return "";
    }

    String randomWalk(){
        return "";
    }

    public static void main(String[] args) {
        TextReader reader = new TextReader();
        String path = System.getProperty("user.dir");
        reader.transformText(path + "\\test.txt", path + "out.txt");
        Graph g = GraphGen.createDirectedGraph(path + "\\out.txt");
        ShowGraph.showDirectedGraph(g);
    }

}

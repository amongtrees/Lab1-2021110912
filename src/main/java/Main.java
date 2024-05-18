import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        TextReader.transformText(path + "\\test.txt", path + "\\out.txt");
        Graph g = GraphGen.createDirectedGraph(path + "\\out.txt");
        ShowGraph.showDirectedGraph(g);
        GenNewText.genNewText(g, "Seek to explore new and \n" +
                "exciting synergies");
        ShortestPath shortestPath = new ShortestPath();
        String shortestPath1 = shortestPath.calcShortestPath(g, "to", "and");
        System.out.println(shortestPath1);
        String text = RandomWalk.randomWalk(g, path + "\\random.txt");
    }

}

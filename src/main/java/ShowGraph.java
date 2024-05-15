import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShowGraph {

    /**
     * build dot script for graph G, and show it with Graphviz
     * @param G is what the GraphGen class has generated
     */
    public static void showDirectedGraph(Graph G){
        StringBuilder dotText = new StringBuilder();
        String newline = System.getProperty("line.separator");
        dotText.append("digraph G{").append(newline);
        for (Node node : G.getNodeList()){
            dotText.append(node.name);
            if (!node.color.equals("black"))
                dotText.append(String.format("[style=filled, fillcolor=%s]",node.color));
            dotText.append(";").append(newline);
        }
        for (Node node : G.getNodeList()){
            for (Edge edge : node.edges){
                dotText.append(String.format("%s->%s[label=%d]", edge.from,edge.to,edge.weight));
                if (!edge.color.equals("black"))
                    dotText.append(String.format("[style=bold, color=%s]",edge.color));
                dotText.append(";").append(newline);
            }
        }
        dotText.append("}").append(newline);

        String graphFilePath = System.getProperty("user.dir") + "\\graph.gv";
        try {
            FileWriter fw = new FileWriter(graphFilePath);
            BufferedWriter bufw = new BufferedWriter(fw);
            bufw.write(dotText.toString());
            bufw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        generateImage(graphFilePath);
    }

    private static void generateImage(String filename){
        Runtime rt = Runtime.getRuntime();
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        String tmpPath = System.getProperty("user.dir");
        String pngPath = tmpPath + "\\img.png";
        try {
            File output = new File(pngPath);
            ImageIO.write(image, "png", output);
            String[] args = {"D:\\Graphviz\\bin\\dot.exe", filename, "-Tpng", "-o", pngPath};
            Process process = rt.exec(args);
            process.waitFor();

        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

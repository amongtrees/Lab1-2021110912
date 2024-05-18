import java.io.*;
import java.util.ArrayList;

public class GraphGen {
    public static Graph createDirectedGraph(String fileLocation){
        Graph G = new Graph();
        File file = new File(fileLocation);
        ArrayList<String> nodes = new ArrayList<>();
        ArrayList<String> edges = new ArrayList<>();
        String[] S = new String[3];
        if (!file.exists())
            return null;
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            int tempint = reader.read();
            char tempchar;
            StringBuilder tempstring = new StringBuilder();
            while (tempint != -1){
                tempchar = (char) tempint;
                if (tempchar == ' '){
                    nodes.add(String.valueOf(tempstring));
                    tempstring = new StringBuilder();
                }
                else {
                    tempstring.append(tempchar);
                }
                tempint = reader.read();
            }
            nodes.add(String.valueOf(tempstring));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        for (int i = 1; i < nodes.size(); i++){
            edges.add( nodes.get(i-1) + " " + nodes.get(i));
        }
        int cnt = 1;
        for (int i = 0; i < edges.size(); i++){
            S = edges.get(i).split(" ");
            if (S.length == 2){
                G.addEdge(S[0], S[1], cnt);
            }
        }
        if (nodes.size() == 1){
            G.addNode(nodes.get(0));
        }
        else if (nodes.isEmpty()){
            return null;
        }

        return G;
    }
}

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShortestPath {
    static Graph tmpGraph;
    static int INF = 0x3f3f3f3f;
    static int size;
    private static int[][] Graph2Matrix(Graph graph){
        tmpGraph = graph;
        size = graph.getNodeList().size();
        int[][] Matrix = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                Matrix[i][j] = INF;
            }
        }
        int index;
        for (index = 0; index < size; index++){
            Node node = graph.getNodeList().get(index);
            for (Edge edge : node.edges){
                String tmpS = edge.to;
                Node tmpN = graph.getNode(tmpS);
                int to = graph.getNodeList().indexOf(tmpN);
                Matrix[index][to] = edge.weight;
            }
        }
        return Matrix;
    }

    private int[] Dijkstra(int[][] Matrix, int source){
        boolean[] visited = new boolean[size];
        int[] distance = new int[size];
        int[] pre_node = new int[size];
        Arrays.fill(distance, INF);
        Arrays.fill(pre_node, -1);
        Arrays.fill(visited, false);
        distance[source] = 0;
        for (int i = 0; i < size ; i++){
            int u = findMinDistanceVertex(distance, visited);
            visited[u] = true;

            for (int v = 0; v < size; v++){
                if (!visited[v] && Matrix[u][v] != INF && distance[u] != INF){
                    if (distance[u] + Matrix[u][v] < distance[v]){
                        distance[v] = distance[u] + Matrix[u][v];
                        pre_node[v] = u;
                    }
                }
            }
        }
        return pre_node;
    }

    private int findMinDistanceVertex(int[] distance, boolean[] visited){
        int minDistance = INF;
        int minIndex = -1;

        for (int v = 0; v < size; v++){
            if (!visited[v] && distance[v] < minDistance){
                minDistance = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public String calcShortestPath(Graph graph, String word1, String word2){
        int[][] Matrix = Graph2Matrix(graph);
        Node tmpN1 = tmpGraph.getNode(word1);
        Node tmpN2 = tmpGraph.getNode(word2);
        int src = tmpGraph.getNodeList().indexOf(tmpN1);
        int dst = tmpGraph.getNodeList().indexOf(tmpN2);
        int[] pre_node = Dijkstra(Matrix, src);
        int i = dst;
        StringBuilder S = new StringBuilder();
        while (pre_node[i] != -1){
            String tmpS = tmpGraph.getNodeList().get(i).name;
            if (S.length() == 0)
                S.insert(0, tmpS);
            else S.insert(0, tmpS + "->");
            i = pre_node[i];
        }
        S.insert(0,word1 + "->");
        return S.toString();
    }

}

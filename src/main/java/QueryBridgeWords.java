public class QueryBridgeWords {
    public static String query(Graph G, String word1, String word2){
        Node node1 = G.getNode(word1);
        Node node2 = G.getNode(word2);
        String S = "";
        if (node1 == null && node2 == null)
            return String.format("No \"%s\" and \"%s\" in the graph!", word1, word2);

        else if (node2 == null)
            return String.format("No \"%s\" in the graph!", word2);
        else if (node1 == null)
            return String.format("No \"%s\" in the graph!", word1);
        else {
            for (Edge edge1 : node1.edges){
                String to = edge1.to;
                Node bridge = G.getNode(to);
                for (Edge edge2 : bridge.edges){
                    if (edge2.to.equals(word2)){
                        if (word2.equals(word1) && word2.equals(bridge) && edge2.weight < 2) continue;
                        if (S.equals("")) S = S + to;
                        else S = S + " " + to;
                    }
                }
            }
        }
        if (S.equals(""))
            return String.format("No bridge words from \"%s\" to \"%s\"!", word1, word2);
        else {
            String[] words = S.split(" ");
            if (words.length == 1)
                return String.format("The bridge word from \"%s\" to \"%s\" is: %s", word1, word2, words[0]);
            else {
                String result = String.format("The bridge words from \"%s\" to \"%s\" are:", word1, word2);
                for (String word : words) {
                    result += " " + word;
                }
                return result;
            }
        }
    }

    public static String[] queryV2(Graph G, String word1, String word2){
        Node node1 = G.getNode(word1);
        Node node2 = G.getNode(word2);
        StringBuilder S = new StringBuilder();
        if (node1 == null && node2 == null)
            return  null;

        else if (node2 == null)
            return null;
        else if (node1 == null)
            return null;
        else {
            for (Edge edge1 : node1.edges){
                String to = edge1.to;
                Node bridge = G.getNode(to);
                for (Edge edge2 : bridge.edges){
                    if (edge2.to.equals(word2)){
                        if (word2.equals(word1) && word2.equals(bridge) && edge2.weight < 2) continue;
                        if (S.length() == 0) S.append(to);
                        else S.append(" ").append(to);
                    }
                }
            }
        }
        if (S.toString().isEmpty())
            return null;
        else {
            return S.toString().split(" ");
        }
    }
}

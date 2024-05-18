import java.util.*;

public class GenNewText {
    static Graph tmpGraph;
    public static String genNewText(Graph G, String Text){
        tmpGraph = G;
        String tmpS1 = standardize(Text);
        String[] tmpS2 = tmpS1.split(" ");
        List<String> S = new ArrayList<>();
        Collections.addAll(S, tmpS2);
        int L = S.size();
        int i ;
        for (i = 0; i < L-1; i++){
            Node tmpNode1 = tmpGraph.getNode(S.get(i).toLowerCase());
            Node tmpNode2 = tmpGraph.getNode(S.get(i + 1).toLowerCase());
            String[] newWords = QueryBridgeWords.queryV2(tmpGraph, tmpNode1.getName(), tmpNode2.getName());
            if (newWords == null)
                continue;
            else {
                if (newWords.length == 1) {
                    S.add(i + 1, newWords[0]);
                    i++;
                }
                else {
                    int range = newWords.length;
                    int j = new Random().nextInt(range);
                    S.add(i + 1, newWords[j]);
                    i++;
                }
            }
        }
        for (String word : S){
            System.out.print(word + " ");
        }

        return null;
    }

    public static String standardize(String Text){
        char tempchar;
        StringBuilder Ans = new StringBuilder();
        int L = Text.length();
        int i = 0;
        StringBuilder tempString = null;
        while (i<L){
            tempchar = Text.charAt(i);
            if (IsChar(tempchar)){
                tempString = new StringBuilder();
                do {
                    tempchar = Text.charAt(i);
                    tempString.append(tempchar);
                    i++;
                }while (i<L && IsChar(Text.charAt(i)));
                if (Ans.toString().equals("")) Ans.append(tempString.toString());
                else Ans = Ans.append(" ").append(tempString.toString());
            }
            i++;
        }
        return Ans.toString();
    }

    static boolean IsChar(char x){
        if ((x >= 'a' && x <= 'z')||(x >= 'A' && x <= 'Z')){
            return true;
        }
        return false;
    }
}

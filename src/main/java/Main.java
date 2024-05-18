import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        TextReader.transformText(path + "\\test.txt", path + "\\out.txt");
        Graph g = GraphGen.createDirectedGraph(path + "\\out.txt");
        ShowGraph.showDirectedGraph(g);
        Scanner scanner = new Scanner(System.in);
        boolean ifBreak = false;
        while (!ifBreak){
            System.out.println("Choose a func: \n 1.Query Bridge Words\n 2.Generate New Text\n 3.Calculate Shortest Path\n 4.Random Walk\n 5.Quit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter word1: ");
                    String word1 = scanner.nextLine();

                    System.out.println("Enter word2: ");
                    String word2 = scanner.nextLine();
                    String brigdeWord = QueryBridgeWords.query(g, word1, word2);
                    System.out.println(brigdeWord);
                    break;

                case 2:
                    System.out.println("Enter an origin text:");
                    String text = scanner.nextLine();
                    GenNewText.genNewText(g, text);
                    break;

                case 3:
                    System.out.println("Enter word1: ");
                    String word3 = scanner.nextLine();

                    System.out.println("Enter word2: ");
                    String word4 = scanner.nextLine();
                    ShortestPath shortestPath = new ShortestPath();
                    String shortestPath1 = shortestPath.calcShortestPath(g, word3, word4);
                    if (shortestPath1 == null)
                        System.out.println("One or both of the words are not in the Graph!");
                    else System.out.println(shortestPath1);
                    break;

                case 4:
                    RandomWalk.randomWalk(g, path + "\\random.txt");
                    break;

                case 5:
                    ifBreak = true;
                    break;
            }
        }
        scanner.close();

    }

}

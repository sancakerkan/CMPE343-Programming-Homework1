import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        int M = scanner.nextInt(); 
        int T = scanner.nextInt(); 
        int C = scanner.nextInt(); 

        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1; 
            graph.addRoute(u, v);
        }

        int X = scanner.nextInt() - 1; 
        int Y = scanner.nextInt() - 1;

        PathFinder pathFinder = new PathFinder(graph, T, C);
        PathFinder.Result result = pathFinder.findShortestPath(X, Y);

        if (result != null) {
            System.out.println(result.path.size());
            result.path.forEach(p -> System.out.print((p + 1) + " ")); 
            System.out.println("\n" + result.totalTime);
        } else {
            System.out.println("No path found");
        }
        
        scanner.close();
    }
    
}

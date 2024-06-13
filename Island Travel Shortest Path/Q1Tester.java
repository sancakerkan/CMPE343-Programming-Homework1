/*package hw1q1;

import hw1q1.Graph;
import hw1q1.PathFinder;

public class Q1Tester {
    public static void main(String[] args) {
        
        Graph graph = new Graph(5);
        graph.addRoute(0, 1);
        graph.addRoute(0, 2);
        graph.addRoute(1, 3);
        graph.addRoute(2, 3);
        graph.addRoute(3, 4);
        
        
        int T = 3; 
        int C = 5; 
        int X = 0; 
        int Y = 4; 
        
        
        PathFinder pathFinder = new PathFinder(graph, T, C);
        PathFinder.Result result = pathFinder.findShortestPath(X, Y);
        
        
        if (result != null) {
            System.out.println("Shortest Path:");
            result.path.forEach(p -> System.out.print((p + 1) + " "));
            System.out.println("\nTotal Time: " + result.totalTime);
        } else {
            System.out.println("No path found");
        }
    }
}
*/
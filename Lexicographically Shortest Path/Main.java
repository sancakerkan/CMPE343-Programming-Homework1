
import java.util.*;

public class Main {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); 
        int M = scanner.nextInt(); 

        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        int X = scanner.nextInt(); 
        int Y = scanner.nextInt(); 

        List<Integer> path = findLexicographicallySmallestPath(graph, X, Y, N);

        
        for (int city : path) {
            System.out.print(city + " ");
        }
        scanner.close();
    }

private static List<Integer> findLexicographicallySmallestPath(Map<Integer, List<Integer>> graph, int start, int end, int numCities) {
    List<Integer> path = new ArrayList<>();
    boolean[] visited = new boolean[numCities + 1];
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    
    dfs(graph, start, end, visited, path, priorityQueue);
    return path;
}

private static boolean dfs(Map<Integer, List<Integer>> graph, int current, int end, boolean[] visited, List<Integer> path, PriorityQueue<Integer> priorityQueue) {
    visited[current] = true;
    path.add(current);

    if (current == end) {
        return true; 
    }

    List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
    for (int neighbor : neighbors) {
        if (!visited[neighbor]) {
            priorityQueue.add(neighbor);
        }
    }

    while (!priorityQueue.isEmpty()) {
        int nextCity = priorityQueue.poll();
        if (dfs(graph, nextCity, end, visited, path, priorityQueue)) {
            return true;
        }
    }

    
    path.remove(path.size() - 1);
    return false;
}

}

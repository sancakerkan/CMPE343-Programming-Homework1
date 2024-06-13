import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class PathFinder {
    private Graph graph;
    private int T; 
    private int C; 

    public PathFinder(Graph graph, int T, int C) {
        this.graph = graph;
        this.T = T;
        this.C = C;
    }

private int calculateWaitTime(int currentTime) {
    int timeSinceLastSwitch = currentTime % T;
    boolean isRunningState = timeSinceLastSwitch < T - C;

   
    if (isRunningState) {
        return 0;  
    } else {
        
        return T - timeSinceLastSwitch;
    }
}




    public Result findShortestPath(int startId, int endId) {
        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s.time));
        Map<Integer, Integer> bestTimes = new HashMap<>();
        queue.add(new State(graph.getIsland(startId), new ArrayList<>(Arrays.asList(startId)), 0));

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.island.id == endId) {
                return new Result(current.path, current.time);
            }

            for (Island neighbor : current.island.neighbors) {
                int arrivalTime = current.time + C + calculateWaitTime(current.time + C);
                int totalTime = arrivalTime;

                
                if (!bestTimes.containsKey(neighbor.id) || bestTimes.get(neighbor.id) > totalTime) {
                    bestTimes.put(neighbor.id, totalTime);
                    List<Integer> newPath = new ArrayList<>(current.path);
                    newPath.add(neighbor.id);
                    queue.add(new State(neighbor, newPath, totalTime));
                }
            }
        }
        return null; 
    }
    static class State {
        Island island;
        List<Integer> path;
        int time;

        public State(Island island, List<Integer> path, int time) {
            this.island = island;
            this.path = path;
            this.time = time;
        }
    }

    static class Result {
        List<Integer> path;
        int totalTime;

        public Result(List<Integer> path, int totalTime) {
            this.path = path;
            this.totalTime = totalTime;
        }
    }
}

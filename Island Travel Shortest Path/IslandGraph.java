import java.util.*;

	class Island {
	    int id;
	    List<Island> neighbors;

	    public Island(int id) {
	        this.id = id;
	        this.neighbors = new ArrayList<>();
	    }

	    public void addNeighbor(Island island) {
	        neighbors.add(island);
	    }
	}

	class Graph {
	    private Island[] islands;

	    public Graph(int numIslands) {
	        islands = new Island[numIslands];
	        for (int i = 0; i < numIslands; i++) {
	            islands[i] = new Island(i);
	        }
	    }

	    public void addRoute(int u, int v) {
	        islands[u].addNeighbor(islands[v]);
	        islands[v].addNeighbor(islands[u]); 
	    }

	    public Island getIsland(int id) {
	        return islands[id];
	    }
	}

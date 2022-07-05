
import java.util.ArrayList;

public class Bridges {
	private void dfs(int node, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj, int timer) {
		// making the start node visited
		
		vis[node] = 1; 
		// timer is initially zero
		tin[node] = low[node] = timer++; // marking the timers for this node and incrementing it

		for(Integer it: adj.get(node)) {
			if(it == parent) continue; // if the adjecent is parent, then ignore 

			if(vis[it] == 0) { 
				// if not visited, then do the dfs
				dfs(it, node, vis, tin, low, adj, timer); 
				low[node] = Math.min(low[node], low[it]); 
				// Calculate the lower time value need for the node based on the adjecent

				if(low[it] > tin[node]) {
					//if the lower of adjenect is greater than the current time, then that is a bridge
					System.out.println(it + " " +node); // this is a bridge
				}
			} else {
				// if already visited node, then mark the update the lower time if needed
				low[node] = Math.min(low[node], tin[it]); 
			}
		}
	}
    void printBridges(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int vis[] = new int[n]; 
        int tin[] = new int[n];
        int low[] = new int[n]; 

        int timer = 0; 
        for(int i = 0;i<n;i++) {
        	if(vis[i] == 0) {
        		dfs(i, -1, vis, tin, low, adj, timer); 
        	}
        }
    }
}

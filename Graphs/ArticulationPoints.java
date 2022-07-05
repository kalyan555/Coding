import java.util.ArrayList;

public class ArticulationPoints {
	private void dfs(int node, int parent, int vis[], int tin[], int low[], ArrayList<ArrayList<Integer>> adj,
			int timer, int isArticulation[]) {
		// making the start node visited
		vis[node] = 1; 
		// timer is initially zero
		tin[node] = low[node] = timer++; // marking the timers for this node and incrementing it
				
		int child = 0;
		for (Integer it : adj.get(node)) {
			if (it == parent)
				continue; // if the adjecant is parent, then ignore 
			if (vis[it] == 0) {
				dfs(it, node, vis, tin, low, adj, timer, isArticulation);
				low[node] = Math.min(low[node], low[it]);
				// Calculate the lower time value need for the node based on the adjecant
				
				if (low[it] >= tin[node] && parent != -1) {
					//if the lower of adjecant is greater than the current time, then that is a bridge
					isArticulation[node] = 1; // this is a articulation point
				}
				child++;
			} else {
				// if already visited node, then mark the update the lower time if needed
				low[node] = Math.min(low[node], tin[it]);
			}
		}
		if (parent != -1 && child > 1)
			isArticulation[node] = 1; //setting the articulation point
	}

	void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
		int vis[] = new int[n];
		int tin[] = new int[n];
		int low[] = new int[n];
		int isArticulation[] = new int[n];
		int timer = 0;
		for (int i = 0; i < n; i++) {
			if (vis[i] == 0) {
				dfs(i, -1, vis, tin, low, adj, timer, isArticulation);
			}
		}
		for (int i = 0; i < n; i++) {
			if (isArticulation[i] == 1)
				System.out.println(i); // printing the articulation node
		}
	}
}

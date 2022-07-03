class Solution {
    public boolean checkForCycle(int node, int parent, boolean vis[], ArrayList < ArrayList 
    < Integer >> adj) {
    	// marking as visited
        vis[node] = true;
        
        // for each of the neighbor check if visited
        for (Integer it: adj.get(node)) {
        	
            if (vis[it] == false) {
            	// if not visited then call this neighbor as next DFS
                if (checkForCycle(it, node, vis, adj) == true)
                    return true;
            } else if (it != parent)  // if visited check if this parent is neighbor, if not parent cycle exists, else no
                return true;
        }

        return false;
    }
   
    
    public boolean isCycle(int V, ArrayList < ArrayList < Integer >> adj) {
    	//Visited Array to keep track of all the visited elements
        boolean vis[] = new boolean[V];

      //Each for loop for each of the disconnected graphs
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
            	//Every time the if is satisfied in case of new sub graph
            	// Calling with current node and -1 (as parent) to the queue
                if (checkForCycle(i, -1, vis, adj))
                    return true;
            }
        }

        return false;
    }
}

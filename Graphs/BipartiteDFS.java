import java.util.*;
class Solution {
	
    static boolean dfsCheck(ArrayList < ArrayList < Integer >> graph, int node, int color[]) {
    	// for each of the neighbor, check if it is colored or not
        for (Integer it: graph.get(node)) {
            if (color[it] == -1) {
                /// if not colored, then color it opposite to the current element;
                color[it] = 1 - color[node];

                if (!dfsCheck(graph, it, color)) // also call the dfs recursively to neighbors
                    return false;
            } else if (color[it] == color[node]) { //if the neighbor and current are of same color, the return false;
                return false;
            }
        }
        return true;
    }

    static boolean checkBipartite(ArrayList < ArrayList < Integer >> graph, int n) {
    	//color Array to keep track of all the visited elements and the colors
        int color[] = new int[n];

        for (int i = 0; i < n; i++) {
            color[i] = -1; // indicating that the node is not yet colored
        }

        for (int i = 0; i < n; i++) {
        	// for each disconnected graph, we take the element and if it is not colored, then we do tarversal and color
            if (color[i] == -1) {
                if (!dfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }
}

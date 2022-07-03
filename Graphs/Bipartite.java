import java.util.*;

class Main
{
	boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		// Queue to insert the elements of a certain level
		Queue<Integer> q = new LinkedList<>();
		
		// Adding current node to the queue
		q.add(node); 
		
		//marking the start element as visited
		color[node] = 1;
		
		//Till the queue is not empty
		while(!q.isEmpty()) {
			Integer nde = q.poll(); 
			
			// for each of the neighbor, check if it is colored or not
			for(Integer it: adj.get(nde)) {
				if(color[it] == -1) {
					// if not colored, then color it opposite to the current element;
					color[it] = 1 - color[nde]; // or use 2 as a color and -2 as other color, color[it] = -color[nde]
					q.add(it); 
				}
				else if(color[it] == color[nde]) {
					//if the neighbor and current are of same color, the return false;
					return false; 
				}
			}
		}
		return true; 
	}

	//Starting Point
    boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
    	//color Array to keep track of all the visited elements and the colors
        int color[] = new int[n];
        for(int i = 0;i<n;i++) {
        	color[i] = -1; // indicating that the node is not yet colored
        }
        for(int i = 0;i<n;i++) {
        	// for each disconnected graph, we take the element and if it is not colored, then we do tarversal and color
        	if(color[i] == -1) {
        		if(!bfsCheck(adj, i, color)) {
        			return false; 
        		}
        	}
        }
        return true; 
    }

}

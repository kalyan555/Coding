import java.util.*;
class Solution {
    public static ArrayList < Integer > bfsOfGraph(int V, ArrayList < ArrayList < Integer >> adj) {

    	//Storing the result
        ArrayList < Integer > bfs = new ArrayList < > ();

        // Visited Array to keep track of all the visited elements
        boolean vis[] = new boolean[V];
        
        // Queue to insert the elements of a certain level
        Queue < Integer > q = new LinkedList < > ();

        //Add the start element(0 here) or add the source vertex if given
        q.add(0);
        
        //making the start element as visited
        vis[0] = true;

        while (!q.isEmpty()) {
        	
        	// keep removing the element
            Integer node = q.poll();
            
            //adding to the result array
            bfs.add(node);

            // visit all the neighbors
            for (Integer it: adj.get(node)) {
            	//check if the neighbor is already visited, if not visited then add the array and mark it as visited
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}

import java.util.*;
import java.lang.*;
import java.io.*;

//class Node to keep track of current and parent
class Node {
	int first;
	int second;

	public Node(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

class Solution {
	static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]) {
		// Queue to insert the elements of a certain level
		Queue<Node> q = new LinkedList<>(); 
		
		// Adding current node and -1 (as parent) to the queue
		q.add(new Node(s, -1));
		
		//making the start element as visited
		vis[s] = true;

		while (!q.isEmpty()) {
			//Getting the current child and parent
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();

			for (Integer it : adj.get(node)) {
				
				// if not visited then, add to the queue and mark as visited
				if (vis[it] == false) {
					q.add(new Node(it, node));
					vis[it] = true;
				}
				// if visited, then check if the parent is the neighbor, 
				//if so then in undirected it is not considered as cycle
				else if (par != it)
					return true;
			}
		}

		return false;
	}

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		//Visited Array to keep track of all the visited elements
		boolean vis[] = new boolean[V];
		
		//Each for loop for each of the disconnected graphs
		for (int i = 0; i < V; i++)
			if (vis[i] == false)
				//Every time the if is satisfied in case of new sub graph
				if (checkForCycle(adj, i, vis))
					return true;

		return false;
	}
}

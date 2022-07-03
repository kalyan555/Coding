package codes;

import java.util.*;

class Solution {
	static void findTopoSort(int node, int vis[], ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		// mark the node as visited
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				findTopoSort(it, vis, adj, st); //if the neighbor is not visited then do dfs
			}
		}
		st.push(node);
	}

	static int[] topoSort(int N, ArrayList<ArrayList<Integer>> adj) {
		Stack<Integer> st = new Stack<Integer>();
		int vis[] = new int[N];

		for (int i = 0; i < N; i++) {
			if (vis[i] == 0) {
				findTopoSort(i, vis, adj, st);
			}
		}

		//Reverse the stack to print the result
		int topo[] = new int[N];
		int ind = 0;
		while (!st.isEmpty()) {
			topo[ind++] = st.pop();
		}
		return topo;
	}
}

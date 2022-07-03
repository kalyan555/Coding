package codes;

import java.util.*;
import java.io.*;
import java.lang.*;
 
class Solution {
    private static boolean checkCycle(int node,  ArrayList<ArrayList<Integer>> adj, int vis[], int dfsVis[]) {
    	//Mark both nodes as visited
        vis[node] = 1;
        dfsVis[node] = 1;
       
        for(Integer neighbor: adj.get(node)) {
        	if(vis[neighbor] == 0) {
            	// for each unvisited neighbor call the dfs recursive call with src as neighbor
                if(checkCycle(neighbor, adj, vis, dfsVis) == true) {
                	return true;
            	}
        	} else if(dfsVis[neighbor] == 1) { 
        		// if the neighbor is visited, then check if it is part of this DFS Traversal
        		// if so, then it means we have a cycle
            	return true;
        	}
        }
        // Remark the Dfs array of source vertex as 0 as it shld not affect other traversal
        dfsVis[node] = 0;
        return false;
    }
    
    
    //Starting Point
    public static boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj) {
    	//vis Array to keep track of all the visited elements 
        int vis[] = new int[N];
        
    	//Dfs  Array to keep track of all the visited elements for that DFS Call of subgraph
        int dfsVis[] = new int[N];
       
        for(int i = 0;i<N;i++) {
        	// Normal DFS Call for unvisited nodes
        	if(vis[i] == 0) {
                if(checkCycle(i, adj, vis, dfsVis) == true) return true;
        	}
        }
        return false;
    }
}

package codes;

import java.util.*; 

//class for the edge
class Node 
{
	private int u;
    private int v;
    private int weight;
    
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

public class Example
{
	// Disjoint Set for finding the parent
	private int findPar(int u, int parent[]) {
		if(u==parent[u]) return u;
		return parent[u] = findPar(parent[u], parent); 
	}
	
	// Disjoint Set for Union Operation
	private void union(int u, int v, int parent[], int rank[]) {
		u = findPar(u, parent); 
		v = findPar(v, parent);
		if(rank[u] < rank[v]) {
        	parent[u] = v;
        }
        else if(rank[v] < rank[u]) {
        	parent[v] = u; 
        }
        else {
        	parent[v] = u;
        	rank[u]++; 
        }
	}
    
	
	void KruskalAlgo(ArrayList<Node> adj, int N)
    {
		// Sort the adj list accoding to the weights
    	Collections.sort(adj, new Comparator<Node>() {
	    	@Override
	    	public int compare(Node o1, Node o2) {
	    		return o1.getWeight()-o2.getWeight();
	    		}
	    });

    	// initialize parent and rank array for the Union By Rank
        int parent[] = new int[N]; 
        int rank[] = new int[N];

        for(int i = 0;i<N;i++) {
        	parent[i] = i; 
        	rank[i] = 0; 
        }

        // initilize the MSTcost as 0
        int costMst = 0;
        ArrayList<Node> mst = new ArrayList<Node>();
        for(Node it: adj) {
        	// for each disconnected edge, add the costMst to the weight and add it 
        	// to the MST list and do the union operator
        	// This give us the MST since the adj is already sorted, so we get the least wts first
        	if(findPar(it.getU(), parent) != findPar(it.getV(), parent)) {
        		costMst += it.getWeight(); 
        		mst.add(it); 
        		union(it.getU(), it.getV(), parent, rank); 
        	}
        } 
        System.out.println(costMst);
        for(Node it: mst) {
        	System.out.println(it.getU() + " - " +it.getV()); 
        }
    }
}

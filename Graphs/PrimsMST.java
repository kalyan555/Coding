package codes;

import java.util.*;

class Node {
    private int v;
    private int weight;

    Node(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    Node() {}

    int getV() {
        return v;
    }
    int getWeight() {
        return weight;
    }
}

public class MST {
	
    void primsAlgo(ArrayList < ArrayList < Node >> adj, int N) {
    	// conatins the weights
        int key[] = new int[N];
        
        //contains the parent for the node
        int parent[] = new int[N];
        
        // boolean array to keep track of already visited nodes
        boolean mstSet[] = new boolean[N];
        for (int i = 0; i < N; i++) {
            key[i] = 100000000;
            mstSet[i] = false;
        }

		// Priority Queue (Min Heap) to store the elements in asceding order of distance
        PriorityQueue<Node> pq = new PriorityQueue<Node>(
        		(node1,node2)-> node1.getWeight()-node2.getWeight());;

        // start with src = 0 -> So distance is 0 and parent is -1
        key[0] = 0;
        parent[0] = -1;
        pq.add(new Node(key[0], 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().getV();
            mstSet[u] = true; // marking the node as visited
            
            for (Node it: adj.get(u)) { // traverse all the adjecents
                if (mstSet[it.getV()] == false && it.getWeight() < key[it.getV()]) {
                	// If the adjecent is not already visited and the weight is less that 
                	//the current wt we get from key array 
                	// then replace the parent of neighbor with current node
                    parent[it.getV()] = u;
                    // set the value in key array with the current element weight
                    key[it.getV()] = it.getWeight();
                    // add the new vertext number and distance DS to the Heap
                    pq.add(new Node(it.getV(), key[it.getV()]));
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}

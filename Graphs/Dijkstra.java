package codes;

import java.util.*;
import java.lang.*;
import java.io.*;

class Dijkstra {
	static final int INF = Integer.MAX_VALUE;

	// store a vertext and the weight for the graph
	static class Vertex {
		private int v;
		private int weight;

		Vertex(int _v, int _w) {
			v = _v;
			weight = _w;
		}

		int getV() {
			return v;
		}

		int getWeight() {
			return weight;
		}

		@Override
		public String toString() {
			return "Vertex [vertex=" + v + ", weight=" + weight + "]";
		}
	}

	// store the node and the distance from the source
	static class Pair {
		private int distance, node;

		public Pair(int distance, int node) {
			super();
			this.distance = distance;
			this.node = node;
		}

		public int getDistance() {
			return distance;
		}

		public int getNode() {
			return node;
		}

		@Override
		public String toString() {
			return "Pair [distance=" + distance + ", node=" + node + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		int n = 5;
		ArrayList<ArrayList<Vertex>> adj = new ArrayList<ArrayList<Vertex>>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Vertex>());
		}

		adj.get(0).add(new Vertex(1, 2));
		adj.get(1).add(new Vertex(0, 2));

		adj.get(1).add(new Vertex(2, 4));
		adj.get(2).add(new Vertex(1, 4));

		adj.get(0).add(new Vertex(3, 1));
		adj.get(3).add(new Vertex(0, 1));

		adj.get(3).add(new Vertex(2, 3));
		adj.get(2).add(new Vertex(3, 3));

		adj.get(1).add(new Vertex(4, 5));
		adj.get(4).add(new Vertex(1, 5));

		adj.get(2).add(new Vertex(4, 1));
		adj.get(4).add(new Vertex(2, 1));
		
//		System.out.println(adj);

		shortestPath(0, 5, adj);


	}

	// driver for djikstra
	private static void shortestPath(int s, int n, ArrayList<ArrayList<Vertex>> adj) {
		// distance array that stores the result
		int[] dis = new int[n];

		// Fill all the elements with max value
		Arrays.fill(dis, Integer.MAX_VALUE);

		// Priority Queue (Min Heap) to store the elements in asceding order of distance
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.distance - o2.distance;
			}
		});
		
	    //  make distance fo source as 0 and add the pair to the Heap
		dis[s] = 0;
		pq.add(new Pair(0,s));
		
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			int node = p.node;
			// Traverse all the neighbors
			for (Vertex v : adj.get(node)) {
				// If the cur_distance + wt to next node < Next_node_distance, 
				// then replace the wt and insert the new Pair(new distance, vertext) into Heap
				if (dis[node] + v.getWeight() < dis[v.getV()]) {
					dis[v.getV()] = dis[node] + v.getWeight();
					pq.add(new Pair(dis[v.getV()], v.getV()));
				}
			}
		}

		System.out.println(Arrays.toString(dis));

	}

}

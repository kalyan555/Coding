package codes;

import java.util.*;

public class Bellman {
	static class Node {
		private int u;
		private int v;
		private int weight;

		Node(int _u, int _v, int _w) {
			u = _u;
			v = _v;
			weight = _w;
		}

		Node() {
		}

		int getV() {
			return v;
		}

		int getU() {
			return u;
		}

		int getWeight() {
			return weight;
		}

	}
	void bellmanFord(ArrayList<Node> edges, int N, int src) {
		int dist[] = new int[N];
		//Initially marks all the nodes distance as INT_MAX or 10e9
		for (int i = 0; i < N; i++)
			dist[i] = 10000000;
		
		dist[src] = 0;
		// src distance is 0

		for (int i = 1; i <= N - 1; i++) { // repeat this for n-1 times are N nodes means n-1 edges
			for (Node node : edges) {
				// for each edge, calm the adjecents
				if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
					dist[node.getV()] = dist[node.getU()] + node.getWeight();
				}
			}
		}

		int fl = 0;
		for (Node node : edges) {
			// If you can futher relax any one of the node, then it means that there shld be a negative cycle
			if (dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
				fl = 1;
				System.out.println("Negative Cycle");
				break;
			}
		}

		if (fl == 0) {
			for (int i = 0; i < N; i++) {
				System.out.print(dist[i] + " ");
			}
		}
	}

	public static void main(String args[]) {
		int n = 6;
		ArrayList<Node> adj = new ArrayList<Node>();

		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

		Bellman obj = new Bellman();
		obj.bellmanFord(adj, n, 0);

	}
}

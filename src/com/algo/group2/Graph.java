package com.algo.group2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by low on 23/10/16 10:52 AM.
 */
class Graph {
	private Boolean[][] graph;
	private Integer[][] distances;
	private Integer[][] shortestPredecessor;
	private ArrayList<ArrayList<Integer>> listGraph;
	private int vertices;
	private int edges;

	Graph(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
		distances = new Integer[vertices][vertices];
		shortestPredecessor = new Integer[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				distances[i][j] = -1;
				shortestPredecessor[i][j] = -1;
			}
			distances[i][i] = 0;
			shortestPredecessor[i][i] = i;
		}
		this.graph = GraphFactory.generateGraph(vertices, edges);
		this.listGraph = GraphFactory.toListGraph(graph, vertices);
	}

	List<Integer> getPath(int from, int to) {
		List<Integer> path = new ArrayList<>();
		int workingVertice = from;
		while (workingVertice != to) {
			path.add(workingVertice);
			workingVertice = shortestPredecessor[workingVertice][to];
		}
		path.add(workingVertice);
		return path;
	}

	Integer getDist(int vertice1, int vertice2) {
		return distances[vertice1][vertice2];
	}

	synchronized void storeDist(int from, int to, int dist, int parent) {
		distances[from][to] = dist;
		distances[to][from] = dist;
		shortestPredecessor[to][from] = parent;
	}

	ArrayList<Integer> linkedVetices(Integer fromVertice) {
		/*for (int i = 0; i < fromVertice; i++) {
			if (graph[i][fromVertice]) {
				linkedVertices.add(i);
			}
		}
		for (int i = (fromVertice+1); i < vertices; i++) {
			if (graph[fromVertice][i]) {
				linkedVertices.add(i);
			}
		}*/
		return listGraph.get(fromVertice);
	}

	int getVertices() {
		return vertices;
	}

	int getEdges() {
		return edges;
	}
}

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
	private int vertices;
	private int edges;

	Graph(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
		distances = new Integer[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				distances[i][j] = -1;
			}
			distances[i][i] = 0;
		}
		this.graph = GraphFactory.generateGraph(vertices, edges);
	}

	Integer getDist(int vertice1, int vertice2) {
		return distances[vertice1][vertice2];
	}

	synchronized void storeDist(int vertice1, int vertice2, int dist) {
		distances[vertice1][vertice2] = dist;
		distances[vertice2][vertice1] = dist;
	}

	List<Integer> linkedVetices(int fromVertice) {
		List<Integer> linkedVertices = new ArrayList<>();
		for (int i = 0; i < fromVertice; i++) {
			if (graph[i][fromVertice]) {
				linkedVertices.add(i);
			}
		}
		for (int i = (fromVertice+1); i < vertices; i++) {
			if (graph[fromVertice][i]) {
				linkedVertices.add(i);
			}
		}
		return linkedVertices;
	}

	int getVertices() {
		return vertices;
	}

	int getEdges() {
		return edges;
	}
}

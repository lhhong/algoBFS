package com.algo.group2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GraphFactory {

	static Boolean[][] generateGraph(int vertices, int edges) {
		Boolean[][] graph = new Boolean[vertices][vertices];
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				graph[i][j] = Boolean.FALSE;
			}
		}
		for (int i = 1; i < edges; i++) {
			while (true) {
				int ran1 = (int) Math.round(Math.floor(Math.random() * vertices));
				int ran2 = (int) Math.round(Math.floor(Math.random() * vertices));
				if (ran1 == ran2) {
					continue;
				}
				if (ran2 < ran1) {
					int temp = ran1;
					ran1 = ran2;
					ran2 = temp;
				}
				if (graph[ran1][ran2]) {
					continue;
				}
				graph[ran1][ran2] = Boolean.TRUE;
				break;
			}
		}
		return graph;
	}

	static ArrayList<ArrayList<Integer>> toListGraph(Boolean[][] graph, int vertices) {
		ArrayList<ArrayList<Integer>> listGraph = new ArrayList<>();
		for (int i=0; i < vertices; i++) {
			listGraph.add(new ArrayList<>());
		}
		for (int i=0; i < vertices; i++) {
			for (int j=i+1; j < vertices; j++) {
				if (graph[i][j]) {
					listGraph.get(i).add(j);
					listGraph.get(j).add(i);
				}
			}
		}
		return listGraph;
	}


}

package com.algo.group2;

import java.util.*;

class BFS {
	private List<Boolean> discovered;
	private Queue<Vertice> queue;
	private Graph graph;
	private Vertice root;

	BFS(Graph graph, int startingVertice) {
		this.graph = graph;
		root = new Vertice(null, startingVertice);
		root.setDistance(0);
		discovered = new ArrayList<>(graph.getVertices());
		for (int i = 0; i < graph.getVertices(); i++) {
			discovered.add(Boolean.FALSE);
		}
		queue = new LinkedList<>();
		enQueue(root);
		BFSFactory.runBFS(this);
	}

	boolean queueNotEmpty() {
		return !queue.isEmpty();
	}

	void enQueue(Vertice vertice) {
		queue.add(vertice);
		discovered.set(vertice.getId(), Boolean.TRUE);
	}

	Vertice deQueue() {
		return queue.remove();
	}

	List<Integer> getUndiscoveredLinks(Vertice vertice) {
		List<Integer> allLinks = graph.linkedVetices(vertice.getId());
		List<Integer> unDiscovered = new ArrayList<>();
		for (Integer link : allLinks) {
			if (discovered.get(link) == Boolean.FALSE) {
				unDiscovered.add(link);
			}
		}
		return unDiscovered;
	}

	List<Boolean> getDiscovered() {
		return discovered;
	}

	Graph getGraph() {
		return graph;
	}

	Vertice getRoot() {
		return root;
	}
}

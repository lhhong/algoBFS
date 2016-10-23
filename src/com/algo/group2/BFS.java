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
		ListIterator<Integer> it = allLinks.listIterator();
		while (it.hasNext()) {
			Integer vert = it.next();
			if (discovered.get(vert) == Boolean.TRUE) {
				it.remove();
			}
		}
		return allLinks;
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

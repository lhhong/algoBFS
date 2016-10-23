package com.algo.group2;

import java.util.ArrayList;
import java.util.List;

class BFSFactory {

	static void runBFS(BFS bfs) {
		while (bfs.queueNotEmpty()) {
			Vertice vertice = bfs.deQueue();
			List<Integer> neigbours = bfs.getUndiscoveredLinks(vertice);
			for (Integer neighbour: neigbours) {
				Vertice next = vertice.addAndReturnChild(neighbour);
				bfs.getGraph().storeDist(bfs.getRoot().getId(), neighbour, next.getDistance());
				bfs.enQueue(next);
			}
		}
	}

	static Integer getUndiscovered(List<BFS> bfsInstances) {
		return getUndiscovered(bfsInstances, bfsInstances.get(0).getGraph().getVertices());
	}

	static Integer getUndiscovered(List<BFS> bfsInstances, int vertices) {
		List<Boolean> discovered = new ArrayList<>(vertices);
		for (int i=0; i<vertices; i++) {
			discovered.add(Boolean.FALSE);
		}
		for (BFS instance: bfsInstances) {
			for (int i = 0; i < vertices; i++) {
				discovered.set(i, (discovered.get(i) || instance.getDiscovered().get(i)));
			}
		}
		return discovered.indexOf(Boolean.FALSE);
	}
}

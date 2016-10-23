package com.algo.group2;

/**
 * Created by low on 23/10/16.
 */
public class BFSThread implements Runnable{

	Count c;
	Graph g;
	int i;

	@Override
	public void run() {
		new BFS(g,i);
		c.increment();
	}

	BFSThread(Count c, Graph g, int vertice) {
		this.g = g;
		this.i = vertice;
		this.c = c;
	}
}

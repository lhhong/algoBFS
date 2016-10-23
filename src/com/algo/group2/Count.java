package com.algo.group2;

/**
 * Created by low on 23/10/16.
 */
public class Count {
	private int count = 0;
	private int vertices;
	private Thread main;

	public Count(Thread main, int vertices) {
		this.vertices = vertices;
		this.main = main;
	}

	synchronized void increment() {
		count ++;
		if (count == vertices) {
			main.interrupt();
		}
	}
}

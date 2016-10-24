package com.algo.group2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String argv[]) {
		List<Integer> verticeList = new ArrayList<>();
		verticeList.add(5000);
		verticeList.add(10000);

		List<Integer> edgesList = new ArrayList<>();
		edgesList.add(1000);
		edgesList.add(5000);
		edgesList.add(10000);
		edgesList.add(50000);
		edgesList.add(100000);

		Graph g = null;
		for (Integer vertices: verticeList) {
			System.out.println("number of vertices: " + vertices + "\n");
			for (Integer edges : edgesList) {
				System.out.println("number of edges: " + edges);
				g = new Graph(vertices, edges);
				long startTime, endTime = 0;

				Count c = new Count(Thread.currentThread(), vertices);
				startTime = System.currentTimeMillis();
				for (int i = 0; i < vertices; i++) {
					BFSThread thread = new BFSThread(c, g, i);
					Thread t = new Thread(thread);
					t.start();
				}
				try {
					Thread.sleep(Long.MAX_VALUE);
				} catch (InterruptedException e) {
					endTime = System.currentTimeMillis();
				}
				System.out.println("time taken: " + (endTime - startTime));
			}
		}

	}


	private static void printTree(Vertice v) {
		System.out.println("parent: " + v.printString());
		System.out.print("children: ");
		for (Vertice c: v.getChildren()) {
			System.out.print(c.printString());
		}
		System.out.println();
		System.out.println();

		v.getChildren().forEach(Main::printTree);

	}

}

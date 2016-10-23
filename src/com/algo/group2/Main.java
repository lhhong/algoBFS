package com.algo.group2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Main {

	public static void main(String argv[]) {
		final int vertices = 500;

		/* THIS CODE REFERS TO PART 2
		List<BFS> multiBfs = new ArrayList<>();

		while (BFSFactory.getUndiscovered(multiBfs, vertices) != -1) {
			BFS bfs = new BFS(g, BFSFactory.getUndiscovered(multiBfs, vertices));
			multiBfs.add(bfs);
			Vertice v = bfs.getRoot();
			System.out.println("\n\nONE BFS RUN...........\n");
			printLevel(v);
		}
		*/

		System.out.println("number of vertices: " + vertices + "\n");

		List<Integer> edgesList = new ArrayList<>();
		edgesList.add(100);
		edgesList.add(500);
		edgesList.add(1000);
		edgesList.add(5000);
		edgesList.add(10000);

		Graph g = null;
		for (Integer edges : edgesList) {
			System.out.println("number of edges: " + edges);
			g = new Graph(vertices, edges);

			long startTime = System.currentTimeMillis();
			for (int i=0; i<vertices; i++) {
				BFS bfs = new BFS(g, i);
			}
			long endTime = System.currentTimeMillis();

			System.out.println("time taken: " + (endTime - startTime));
		}

		do {
			Scanner sc = new Scanner(System.in);
			System.out.print("enter 2 vertices to find shortest distance: ");

			assert g != null;
			System.out.println("shortest dist: " + g.getDist(sc.nextInt(), sc.nextInt()));
		} while (true);
	}

	private static void printLevel(Vertice v) {
		System.out.println("parent: " + v.printString());
		System.out.print("children: ");
		for (Vertice c: v.getChildren()) {
			System.out.print(c.printString());
		}
		System.out.println();

		v.getChildren().forEach(Main::printLevel);

	}

}

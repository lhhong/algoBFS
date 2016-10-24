package com.algo.group2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDemo {

	public static void main(String argv[]) {
		int vertices;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of vertices: ");
		vertices = sc.nextInt();

		System.out.println();
		System.out.println("1: Map a graph");
		System.out.println("2: Pre-process a graph");
		int part = sc.nextInt();

		switch (part) {
			case 1:
				List<BFS> multiBfs = new ArrayList<>();
				System.out.println("Enter number of edges: ");
				int edge = sc.nextInt();
				Graph graph = new Graph(vertices, edge);

				while (BFSFactory.getUndiscovered(multiBfs, vertices) != -1) {
					BFS bfs = new BFS(graph, BFSFactory.getUndiscovered(multiBfs, vertices));
					multiBfs.add(bfs);
					Vertice v = bfs.getRoot();
					System.out.println("\n\nONE BFS RUN...........\n");
					printTree(v);
				}
				break;
			case 2:
				System.out.println("Enter number of edges: ");
				int edges = sc.nextInt();

				Graph g = null;
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
				int choice;

				do {

					System.out.println();
					System.out.println("1: find shortest distance");
					System.out.println("2: print selected tree");
					System.out.println("3: exit");

					choice = sc.nextInt();
					switch (choice) {
						case 1:
							System.out.print("enter 2 vertices to find shortest distance: ");

							assert g != null;
							int from, to;
							from = sc.nextInt();
							to = sc.nextInt();
							int dist = g.getDist(from, to);
							if (dist == -1) {
								System.out.println("no path found");
								break;
							}
							System.out.println("Shortest dist: " + dist);
							List<Integer> path = g.getPath(from, to);
							System.out.print("Pathway: " + path.get(0));
							for (int i = 1; i < path.size(); i++) {
								System.out.print(" -> " + path.get(i));
							}
							System.out.println();
							break;
						case 2:
							System.out.print("enter root vertice to print: ");
							BFS bfs = new BFS(g, sc.nextInt());
							printTree(bfs.getRoot());
							break;
					}

				} while (choice != 3);
				break;
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

		v.getChildren().forEach(MainDemo::printTree);

	}

}

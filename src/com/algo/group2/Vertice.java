package com.algo.group2;

import java.util.ArrayList;
import java.util.List;

class Vertice {
	private Vertice parent;
	private List<Vertice> children;
	private int id;
	private int distance;

	Vertice(Vertice parent, int id) {
		this.id = id;
		this.parent = parent;
		children = new ArrayList<>();
	}

	int getId() {
		return id;
	}

	Vertice getParent() {
		return parent;
	}

	void setParent(Vertice parent) {
		this.parent = parent;
	}

	List<Vertice> getChildren() {
		return children;
	}

	Vertice addAndReturnChild(int vertice) {
		Vertice child = new Vertice(this, vertice);
		child.setDistance(distance + 1);
		children.add(child);
		return child;
	}

	int getDistance() {
		return distance;
	}

	void setDistance(int distance) {
		this.distance = distance;
	}

	String printString() {
		return "(" + id + ", " + distance + ")\t";
	}
}

package com.graph.circularReference;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private List<Node> children;
	
	public Node() {
		children = new ArrayList<Node>();
	}
	
	public List<Node> getChildren() {
		return children;
	}
	
	public void addChild(Node newChild) {
		children.add(newChild);
	}
}

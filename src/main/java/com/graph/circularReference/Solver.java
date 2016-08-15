package com.graph.circularReference;

import java.util.ArrayList;
import java.util.List;

public class Solver {

    public boolean hasCircularReference(Node startNode, Node endNode) {
    	return hasCircularReference(startNode, endNode, new ArrayList<Node>());
    }
    
    private boolean hasCircularReference(Node startNode, Node endNode, List<Node> visitedNodes) {
    	visitedNodes.add(startNode);
    	
    	if(startNode.getChildren().stream().anyMatch(visitedNodes::contains)) {
    		return true;
    	}
    	
    	return startNode
    		.getChildren()
    		.stream()
    		.anyMatch(child -> hasCircularReference(child, endNode, visitedNodes));
    }
}
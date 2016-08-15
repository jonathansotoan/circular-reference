package com.graph.circularReference;

import java.util.*;

public class Solver {
    public static void main (String[] args) throws java.lang.Exception	{
    	Solver ideone = new Solver();
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();
        graph.put("A", Arrays.asList(new String[]{"B", "C"}));
        graph.put("B", Arrays.asList(new String[]{"D", "E"}));
        graph.put("C", Arrays.asList(new String[]{"D", "E"}));
        graph.put("D", Arrays.asList(new String[]{"E"}));
        graph.put("E", Arrays.asList(new String[]{"F"}));
        graph.put("F", new ArrayList<String>());
        System.out.println(ideone.hasCyclicReference("A", "F", graph, new ArrayList<String>()));
    }
 
    private boolean hasCyclicReference (String startNode, String endNode, HashMap<String, List<String>> graph, ArrayList<String> visited) {
        if (startNode.equals(endNode)) {
            return false;
        }
 
        visited.add(startNode);
 
        List<String> childNodes = graph.get(startNode);
        for (String childNode : childNodes) {
            if (childNode.equals(endNode)) {
                continue;
            }
            if (visited.contains(childNode)) {
                return true;
            }
            if (this.hasCyclicReference(childNode, endNode, graph, visited)) {
                return true;
            }
            visited.remove(childNode);
        }
        return false;
    }
}
package com.graph.circularReference;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolverTests {
	private Solver solver;

	@Before
	public void setUp() {
		solver = new Solver();
	}

	@Test
	public void hasCircularReference_ShouldReturnTrue_WhenThereIsACircularReference() {		
		Node nodeA = new Node();
		Node nodeB = new Node();
		Node nodeC = new Node();
		Node nodeD = new Node();
		
		nodeA.addChild(nodeB);
		nodeB.addChild(nodeC);
		nodeC.addChild(nodeA);
		nodeC.addChild(nodeD);
		
		boolean hasCircularReference = solver.hasCircularReference(nodeA, nodeD);
		
		Assert.assertTrue(hasCircularReference);
	}

	@Test
	public void hasCircularReference_ShouldReturnFalse_WhenThereIsNotACircularReference() {		
		Node nodeA = new Node();
		Node nodeB = new Node();
		Node nodeC = new Node();
		
		nodeA.addChild(nodeB);
		nodeB.addChild(nodeC);
		
		boolean hasCircularReference = solver.hasCircularReference(nodeA, nodeC);
		
		Assert.assertFalse(hasCircularReference);
	}

	@Test
	public void hasCircularReference_ShouldReturnFalse_WhenStartAndEndNodesAreTheSame() {		
		Node nodeA = new Node();
		
		boolean hasCircularReference = solver.hasCircularReference(nodeA, nodeA);
		
		Assert.assertFalse(hasCircularReference);
	}

	@Test
	public void hasCircularReference_ShouldReturnTrue_WhenCircularReferenceIsNotTheFirstPossiblePath() {		
		Node nodeA = new Node();
		Node nodeB = new Node();
		Node nodeC = new Node();
		Node nodeD = new Node();
		
		nodeA.addChild(nodeB);
		nodeB.addChild(nodeC);
		nodeC.addChild(nodeD);
		nodeC.addChild(nodeA);
		
		boolean hasCircularReference = solver.hasCircularReference(nodeA, nodeD);
		
		Assert.assertTrue(hasCircularReference);
	}

	@Test
	public void hasCircularReference_ShouldReturnFalse_WhenNodesAreUnrelated() {		
		Node nodeA = new Node();
		Node nodeB = new Node();
		Node nodeC = new Node();
		Node nodeD = new Node();
		Node nodeE = new Node();
		
		nodeA.addChild(nodeB);
		nodeB.addChild(nodeC);
		nodeD.addChild(nodeE);
		
		boolean hasCircularReference = solver.hasCircularReference(nodeA, nodeE);
		
		Assert.assertFalse(hasCircularReference);
	}
}

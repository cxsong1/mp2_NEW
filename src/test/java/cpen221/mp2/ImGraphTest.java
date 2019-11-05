package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
public class ImGraphTest {
	@Test
	public void testDistinctGraphs(){

		Vertex A = new Vertex(1, "A");
		Vertex B = new Vertex(2, "B");
		Vertex C = new Vertex(3, "C");
		Vertex D = new Vertex(4, "D");
		Vertex E = new Vertex(5, "E");
		Vertex F = new Vertex(6, "F");

		Graph g = TestUtils.createGraph1();

		Set<Set<Vertex>> graphSet = new HashSet<>();
		HashSet<Vertex> graph1 = new HashSet<>();
		HashSet<Vertex> graph2 = new HashSet<>();

		graph1.add(A);
		graph1.add(B);

		graph2.add(C);
		graph2.add(D);
		graph2.add(E);
		graph2.add(F);

		graphSet.add(graph1);
		graphSet.add(graph2);

		assertEquals(graphSet, g.shatter());
	}
}

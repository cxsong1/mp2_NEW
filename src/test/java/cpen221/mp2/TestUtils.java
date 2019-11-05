package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;

public class TestUtils {

	public static Graph<Vertex, Edge<Vertex>> createGraph1() {
		Vertex A = new Vertex(1, "A");
		Vertex B = new Vertex(2, "B");
		Vertex C = new Vertex(3, "C");
		Vertex D = new Vertex(4, "D");
		Vertex E = new Vertex(5, "E");
		Vertex F = new Vertex(6, "F");

		Edge<Vertex> e1 = new Edge<>(A,B,1);
		Edge<Vertex> e2 = new Edge<>(C,D,2);
		Edge<Vertex> e3 = new Edge<>(C,E,3);
		Edge<Vertex> e4 = new Edge<>(D,E,4);
		Edge<Vertex> e5 = new Edge<>(D,F,5);

		Graph<Vertex, Edge<Vertex>> g = new Graph<>();
		g.addVertex(A);
		g.addVertex(B);
		g.addVertex(C);
		g.addVertex(D);
		g.addVertex(E);
		g.addVertex(F);

		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);

		return g;
	}
}

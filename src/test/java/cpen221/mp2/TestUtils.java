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

	public static Graph<Vertex, Edge<Vertex>> createGraph2() {
		Vertex v1 = new Vertex(1, "A");
		Vertex v2 = new Vertex(2, "B");
		Vertex v3 = new Vertex(3, "C");
		Vertex v4 = new Vertex(4, "D");

		Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
		Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
		Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

		Graph<Vertex, Edge<Vertex>> g = new Graph<>();
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);

		return g;
	}

	public static Graph<Vertex, Edge<Vertex>> createGraph3() {
		Vertex v1 = new Vertex(1, "A");
		Vertex v2 = new Vertex(2, "B");
		Vertex v3 = new Vertex(3, "C");
		Vertex v4 = new Vertex(4, "D");
		Vertex v5 = new Vertex(5, "E");
		Vertex v6 = new Vertex(6, "F");

		Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
		Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
		Edge<Vertex> e3 = new Edge<>(v1, v4, 9);
		Edge<Vertex> e4 = new Edge<>(v1, v5, 6);
		Edge<Vertex> e5 = new Edge<>(v2, v6, 3);

		Graph<Vertex, Edge<Vertex>> g2 = new Graph<>();
		g2.addVertex(v1);
		g2.addVertex(v2);
		g2.addVertex(v3);
		g2.addVertex(v4);
		g2.addVertex(v5);
		g2.addVertex(v6);
		g2.remove(v6);
		g2.addEdge(e1);
		g2.addEdge(e2);
		g2.addEdge(e3);

		return g2;
	}

	public static Graph<Vertex, Edge<Vertex>> createGraph4() {
		Vertex v1 = new Vertex(1, "a");
		Vertex v2 = new Vertex(2, "a");
		Vertex v3 = new Vertex(3, "a");
		Vertex v4 = new Vertex(4, "a");

		Edge<Vertex> e1 = new Edge<>(v1, v2, 10);
		Edge<Vertex> e2 = new Edge<>(v1, v3, 10);
		Edge<Vertex> e3 = new Edge<>(v2, v3, 1);
		Edge<Vertex> e4 = new Edge<>(v3, v4, 1);
		Edge<Vertex> e5 = new Edge<>(v1, v4, 20);

		Graph<Vertex, Edge<Vertex>> g = new Graph<>();

		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);

		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);

		return g;
	}

	//graph used to test shortest path
	public static Graph<Vertex, Edge<Vertex>> createGraph5() {
		Vertex A = new Vertex(1, "A");
		Vertex B = new Vertex(2, "B");
		Vertex C = new Vertex(3, "C");
		Vertex D = new Vertex(4, "D");
		Vertex E = new Vertex(5, "E");
		Vertex F = new Vertex(6, "F");
		Vertex G = new Vertex(7, "G");

		Edge<Vertex> e1 = new Edge<>(A,B, 4);
		Edge<Vertex> e2 = new Edge<>(B,D,5);
		Edge<Vertex> e3 = new Edge<>(B,C,6);
		Edge<Vertex> e4 = new Edge<>(C,D,11);
		Edge<Vertex> e5 = new Edge<>(A,C,3);
		Edge<Vertex> e6 = new Edge<>(C,E,8);
		Edge<Vertex> e7 = new Edge<>(A,E,7);
		Edge<Vertex> e8 = new Edge<>(D,E,2);
		Edge<Vertex> e9 = new Edge<>(D,F,2);
		Edge<Vertex> e10 = new Edge<>(F,G,3);
		Edge<Vertex> e11 = new Edge<>(D,G,10);
		Edge<Vertex> e12 = new Edge<>(E,G,5);

		Graph<Vertex, Edge<Vertex>> g = new Graph<>();

		g.addVertex(A);
		g.addVertex(B);
		g.addVertex(C);
		g.addVertex(D);
		g.addVertex(E);
		g.addVertex(F);
		g.addVertex(G);

		g.addEdge(e1);
		g.addEdge(e2);
		g.addEdge(e3);
		g.addEdge(e4);
		g.addEdge(e5);
		g.addEdge(e6);
		g.addEdge(e7);
		g.addEdge(e8);
		g.addEdge(e9);
		g.addEdge(e10);
		g.addEdge(e11);
		g.addEdge(e12);

		return g;
	}

	public static Graph<Vertex, Edge<Vertex>> createGraph6() {
		Vertex A = new Vertex(1, "A");
		Vertex B = new Vertex(2, "B");
		Vertex C = new Vertex(3, "C");
		Vertex D = new Vertex(4, "D");
		Vertex E = new Vertex(5, "E");
		Vertex F = new Vertex(6, "F");

		Edge<Vertex> e1 = new Edge<>(A,B,1);
		Edge<Vertex> e2 = new Edge<>(C,D,2);
		Edge<Vertex> e3 = new Edge<>(C,E,8);
		Edge<Vertex> e4 = new Edge<>(D,E,5);
		Edge<Vertex> e5 = new Edge<>(D,F,3);

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

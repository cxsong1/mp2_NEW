package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    //Creates a graph to be used for tests
    public Graph<Vertex, Edge<Vertex>> createGraph1() {
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

    public Graph<Vertex, Edge<Vertex>> createGraph2() {
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

	 /** testAddVertex()
	 * Test addVertex by adding:
	 * 1) a new vertex
	 * 2) an existing vertex in the graph
	 * return: True, False
	 */
    @Test
	  public void testAddVertex(){
    	Graph g = createGraph1();
	    Vertex v6 = new Vertex(6, "Horseradish actually sucks");
	    Vertex v1 = new Vertex(1, "A");

	    assertTrue(g.addVertex(v6));
	    assertFalse(g.addVertex(v1));
    }

	/** testAddEdge()
	 * Test addEdge by adding:
	 * 1) a new vertex
	 * 2) an existing vertex in the graph
	 * return: True, False
	 */
	@Test
	public void testAddEdge(){
		Graph g = createGraph1();
		Vertex v6 = new Vertex(6, "Horseradish actually sucks");
		Vertex v1 = new Vertex(1, "A");

		assertTrue(g.addVertex(v6));
		assertFalse(g.addVertex(v1));
	}

	/** testRemove1()
	 * Test remove by removing:
	 * 1) a vertex not on the graph
	 * 2) an existing vertex in the graph
	 *      this should also remove the edges containing that vertex as well
	 */
	@Test
	public void testRemove1(){
		Graph g = createGraph1();
		Vertex v6 = new Vertex(6, "Horseradish actually sucks");
		Vertex v1 = new Vertex(1, "A");
		Vertex v2 = new Vertex(2, "B");
		Vertex v4 = new Vertex(4, "D");

		Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
		Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

		assertFalse(g.remove(v6));
		assertTrue(g.remove(v1));
		assertFalse(g.edge(e1));
		assertFalse(g.edge(e3));
	}

	/** testRemove2()
	 * Test remove by removing:
	 * 1) a vertex not on the graph
	 * 2) an existing vertex in the graph
	 *      this should also remove the edges containing that vertex as well
	 */
	@Test
	public void testRemove2(){
		Graph g = createGraph2();

		assertFalse(g.remove(v6));
		assertTrue(g.remove(v1));
		assertFalse(g.edge(e1));
		assertFalse(g.edge(e3));
	}

	/** testRemove3()
	 * Test remove by removing:
	 * 1) an edge not on the graph
	 * 2) an existing edge in the graph
	 * return: True, False
	 */
	@Test
	public void testRemove3(){
		Graph g = createGraph1();
		Vertex v6 = new Vertex(6, "Horseradish actually sucks");
		Vertex v1 = new Vertex(1, "A");
		Vertex v2 = new Vertex(2, "B");

		Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
		Edge<Vertex> e6 = new Edge<>(v1, v6, 9);

		assertFalse(g.remove(e6));
		assertTrue(g.remove(e1));
	}

}


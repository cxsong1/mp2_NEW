package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Test;

import static org.junit.Assert.*;

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

    /**
     * Tests that the `vertex` method returns true if the graph contains that vertex,
     * and false if it does not.
     */
    @Test
    public void testVertex() {
        Graph g = createGraph1();
        assertTrue(g.vertex(new Vertex(1, "A")));
        assertFalse(g.vertex(new Vertex(3, "Horseradish is one hell of a condiment.")));
    }

    /**
     * Tests that the `edge` method returns true if an edge exists in the graph, and
     * false if that edge is not contained.
     */
    @Test
    public void testEdge1() {
        Graph g = createGraph1();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        assertTrue(g.edge(new Edge(v2, v3)));
        assertFalse(g.edge(new Edge(v1, v3)));
    }

    /**
     * Tests that the `edge` method returns true if an edge exists in the graph, and
     * false if that edge is not contained.
     */
    @Test
    public void testEdge2() {
        Graph g = createGraph1();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        assertTrue(g.edge(v2, v3));
        assertFalse(g.edge(v1, v3));
    }

    /**
     * Ensures that `edgeLength` correctly retrieves an edge and returns its length.
     */
    @Test
    public void testEdgeLength() {
        Graph g = createGraph1();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        assertEquals(5, g.edgeLength(v1, v2));
        assertEquals(7, g.edgeLength(v2, v3));
        assertEquals(9, g.edgeLength(v1, v4));
    }

    @Test
    public void testEdgeLengthSum() {
        Graph g = createGraph1();
        assertEquals(21, g.edgeLengthSum());

        g = createGraph2();
        assertEquals(21, g.edgeLengthSum());
    }
    
    @Test
    public void testAllEdges() {
        Graph g = createGraph1();

        Set<Edge> edges = g.allEdges();


    }
}

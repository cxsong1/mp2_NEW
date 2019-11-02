package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Set;
import java.util.Map;
import java.util.List;

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

    public Graph<Vertex, Edge<Vertex>> createGraph3() {
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
    public Graph<Vertex, Edge<Vertex>> createGraph4() {
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
    public void testAllEdges1() {
        Graph g = createGraph1();

        Set<Edge> edges = g.allEdges();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

        assertTrue(edges.contains(e1));
        assertTrue(edges.contains(e2));
        assertTrue(edges.contains(e3));
        assertEquals(3, edges.size());
    }

    @Test
    public void testAllEdges2() {
        Graph g = createGraph1();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

        Set<Edge> edges = g.allEdges(v2);

        assertTrue(edges.contains(e1));
        assertTrue(edges.contains(e2));
        assertFalse(edges.contains(e3));
        assertEquals(2, edges.size());
    }

    @Test
    public void testAllVertices() {
        Graph g = createGraph1();

        Set<Vertex> vert = g.allVertices();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        assertTrue(vert.contains(v1));
        assertTrue(vert.contains(v2));
        assertTrue(vert.contains(v3));
        assertTrue(vert.contains(v4));
        assertEquals(4, vert.size());
    }

    @Test
    public void testGetNeighbours() {
        Graph g = createGraph1();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e2 = new Edge<>(v2, v3, 7);
        Edge<Vertex> e3 = new Edge<>(v1, v4, 9);

        Map<Vertex, Edge> n = g.getNeighbours(v1);

        assertEquals(e1, n.get(v2));
        assertEquals(e3, n.get(v4));
        assertEquals(2, n.size());
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
        Vertex v6 = new Vertex(6, "My name is claire, and I love horseradish");
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e6 = new Edge<>(v1, v6, 9);

        assertFalse(g.remove(e6));
        assertTrue(g.remove(e1));
    }

    @Test
    public void testMST() {
        Graph g = createGraph3();

        Vertex v1 = new Vertex(1, "a");
        Vertex v2 = new Vertex(2, "a");
        Vertex v3 = new Vertex(3, "a");
        Vertex v4 = new Vertex(4, "a");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 10);
        Edge<Vertex> e2 = new Edge<>(v1, v3, 10);
        Edge<Vertex> e3 = new Edge<>(v2, v3, 1);
        Edge<Vertex> e4 = new Edge<>(v3, v4, 1);
        Edge<Vertex> e5 = new Edge<>(v1, v4, 20);
        
        List<Edge> mst = g.minimumSpanningTree();

        assertEquals(3, mst.size());
        assertTrue(mst.contains(e1));
        
        int length = 0;
        for (Edge e : mst) {
            length += e.length();
        }

        assertEquals(length, 12);
    }

    @Test
    public void testShortestPath(){
        Graph<Vertex, Edge<Vertex>> g = createGraph4();
        LinkedList<Vertex> path = new LinkedList<>();

        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex D = new Vertex(4, "D");
        Vertex F = new Vertex(6, "F");

        path.add(A);
        path.add(B);
        path.add(D);
        path.add(F);

        assertEquals(path, g.shortestPath(A,F));

    }
}

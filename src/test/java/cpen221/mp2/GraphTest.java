package cpen221.mp2;

import cpen221.mp2.graph.Edge;
import cpen221.mp2.graph.Graph;
import cpen221.mp2.graph.Vertex;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GraphTest {

    /**
     * Tests that the `vertex` method returns true if the graph contains that vertex,
     * and false if it does not.
     */
    @Test
    public void testVertex() {
        Graph g = TestUtils.createGraph2();
        assertTrue(g.vertex(new Vertex(1, "A")));
        assertFalse(g.vertex(new Vertex(3, "Horseradish is one hell of a condiment.")));
    }

    /**
     * Tests that the `edge` method returns true if an edge exists in the graph, and
     * false if that edge is not contained.
     */
    @Test
    public void testEdge1() {
        Graph g = TestUtils.createGraph2();

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
        Graph g = TestUtils.createGraph2();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        assertTrue(g.edge(v2, v3));
        assertFalse(g.edge(v1, v3));
    }

    /**
     * Tests that the edge method throws an IllegalArgumentException
     * if we try and create an edge with null vertices
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testEdge3(){
        Graph g = TestUtils.createGraph2();

        assertTrue(g.edge(new Edge(null,null)));
    }

    /**
     * Tests that the edge method throws an IllegalArgumentException
     * if we try and create an edge with two vertices that are identical
     */
    @Test (expected = IllegalArgumentException.class)
    public void testEdge4(){
        Graph g = TestUtils.createGraph2();
        Vertex v1 = new Vertex(1, "A");

        assertTrue(g.edge(new Edge(v1,v1,1)));
    }

    /**
     *Tests that the edge method throws an IllegalArgumentException
     * if we try and create an edge with a negative length
     */
    @Test (expected = IllegalArgumentException.class)
    public void testEdge5(){
        Graph g = TestUtils.createGraph2();
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");

        assertTrue(g.edge(new Edge(v1,v2,-1)));
    }

    /**
     * Tests that the incident method returns
     *      true: for v1, a vertex that is contained on e1
 *          false: for v3, a vertex that is not on e1
 *          false: for a null vertex
     */
    @Test
    public void testIncident(){
        Graph g = TestUtils.createGraph2();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        Edge e1 = new Edge(v1,v2,1);

        assertTrue(e1.incident(v1));
        assertFalse(e1.incident(v3));
        assertFalse(e1.incident(null));
    }

    /**
     * Tests if 'Intersects' method returns
     *      false: for an intersection with a null vertex
     *      true: if e1 and e2 have a common vertex
     */
    @Test
    public void testIntersects(){
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        Edge e1 = new Edge(v1,v2,1);
        Edge e2 = new Edge(v1,v3,1);

        assertTrue(e1.intersects(e2));
        assertFalse(e1.intersects(null));
    }

    /**
     * Tests if 'intersection' method throws a NoSuchElementException
     * if a null edge is passed
     */
    @Test (expected = NoSuchElementException.class)
    public void testIntersection() throws NoSuchElementException{
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        Edge e1 = new Edge(v1,v2,1);
        Edge e2 = new Edge(v1,v3,1);
        assertEquals(v1, e1.intersection(null));
    }

    /**
     * Tests if 'intersection' method throws a NoSuchElementException
     * if there is no common vertex between two edges
     */
    @Test (expected = NoSuchElementException.class)
    public void testIntersection2() throws NoSuchElementException{
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        Edge e1 = new Edge(v1,v2,1);
        Edge e2 = new Edge(v4,v3,1);
        assertEquals(v1, e1.intersection(e2));
    }

    /**
     * Tests 'intersection' for edges that have a common vertex
     * Expected: the intersection between e1 and e2 is v1
     *           the intersection between e3 and e4 is v2
     */
    @Test
    public void testIntersection3(){
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        Edge e1 = new Edge(v1,v2,1);
        Edge e2 = new Edge(v1,v3,1);
        Edge e3 = new Edge(v1,v2,1);
        Edge e4 = new Edge(v3,v2,1);

        assertEquals(v1,e1.intersection(e2));
        assertEquals(v2, e3.intersection(e4));
    }

    /**
     * Tests 'distinctVertex' method
     * Expected: the "other" vertex in the edge that is not the one passed to the function
     */
    @Test
    public void testDistinctVertex(){
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");

        Edge e1 = new Edge(v1,v2,1);

        assertEquals(v1, e1.distinctVertex(v2));
        assertEquals(v2, e1.distinctVertex(v1));
    }

    /**
     * Tests 'distinctVertex' method that takes an edge as a parameter
     * Expected: throws NoSuchElementException since e1 and e2 are the same edge
     */
    @Test (expected = NoSuchElementException.class)
    public void testDistinctVertex2() throws NoSuchElementException{
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Edge e1 = new Edge(v1,v2,1);
        Edge e2 = new Edge(v1,v2,1);
        assertEquals(v1, e1.distinctVertex(e2));
    }

    /**
     * Tests 'distinctVertex' method that takes an edge as a parameter
     * Expected:
     *      1) returns v1 since all vertices are distinct
     *      2) returns v2
     *      3) returns v1
     */
    @Test
    public void testDistinctVertex3(){
	    Vertex v1 = new Vertex(1, "A");
	    Vertex v2 = new Vertex(2, "B");
	    Vertex v3 = new Vertex(3, "C");
	    Vertex v4 = new Vertex(4, "D");
	    Vertex v5 = new Vertex(5, "E");

	    Edge e1 = new Edge(v1,v2,1);
	    Edge e2 = new Edge(v4,v3,1);
	    Edge e3 = new Edge(v4,v2,1);
	    Edge e4 = new Edge(v4,v1,1);
	    Edge e5 = new Edge(v1,v5,1);
	    Edge e6 = new Edge(v2,v5,1);

	    assertEquals(v1, e1.distinctVertex(e2));
	    assertEquals(v2, e3.distinctVertex(e4));
	    assertEquals(v1, e5.distinctVertex(e6));
    }

    /**
     * Ensures that `edgeLength` correctly retrieves an edge and returns its length.
     */
    @Test
    public void testEdgeLength() {
        Graph g = TestUtils.createGraph2();

        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");
        Vertex v4 = new Vertex(4, "D");

        assertEquals(5, g.edgeLength(v1, v2));
        assertEquals(7, g.edgeLength(v2, v3));
        assertEquals(9, g.edgeLength(v1, v4));
        assertEquals(-1, g.edgeLength(v1,v3));
    }

    /**
     * Tests the 'edgeLengthSum' method
     * Returns the sum of all the lengths of the edges in graph2
     */
    @Test
    public void testEdgeLengthSum() {
        Graph g = TestUtils.createGraph2();
        assertEquals(21, g.edgeLengthSum());
    }

    /**
     * Tests 'allEdges' method
     * Checks to see if the set contains the appropriate
     * edges and is the correct size
     */
    @Test
    public void testAllEdges1() {
        Graph g = TestUtils.createGraph2();

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

    /**
     * Second test to test 'allEdges' method
     * Checks to see if the set contains the appropriate
     * edges and is the correct size
     */
    @Test
    public void testAllEdges2() {
        Graph g = TestUtils.createGraph2();

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

    /**
     * Tests 'allVertices' method
     * Checks to see if the set contains the appropriate
     * vertices and is the correct size
     */
    @Test
    public void testAllVertices() {
        Graph g = TestUtils.createGraph2();

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

    /**
     * Tests 'getNeighbours' method
     * Returns a map containing all the neighbours of vertex v1
     *      along with the edge connecting the two neighbours
     *  Check that the value (edge) corresponding to the neighbour vertex (key) is correct
     */
    @Test
    public void testGetNeighbours() {
        Graph g = TestUtils.createGraph2();

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
        Graph g = TestUtils.createGraph2();
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
        Graph g = TestUtils.createGraph2();
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");
        Vertex v3 = new Vertex(3, "C");

        assertFalse(g.addEdge(new Edge<>(v1, v2, 5)));
        assertTrue(g.addEdge(new Edge<>(v1,v3,2)));
    }

    /** testRemove1()
     * Test remove by removing:
     * 1) a vertex not on the graph
     * 2) an existing vertex in the graph
     *      this should also remove the edges containing that vertex as well
     */
    @Test
    public void testRemove1(){
        Graph g = TestUtils.createGraph2();
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
        Graph g = TestUtils.createGraph3();

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
        Graph g = TestUtils.createGraph2();
        Vertex v6 = new Vertex(6, "My name is claire, and I love horseradish");
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(2, "B");

        Edge<Vertex> e1 = new Edge<>(v1, v2, 5);
        Edge<Vertex> e6 = new Edge<>(v1, v6, 9);

        assertFalse(g.remove(e6));
        assertTrue(g.remove(e1));
    }
    /**
     * Tests 'MST' method
     * Returns a list containing all the edges that form the minimum spanning tree
     * Check the size of the list and the length of the the minimum spanning tree
     */
    @Test
    public void testMST() {
        Graph g = TestUtils.createGraph4();

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

    /**
     *  Tests 'MST' method with a disconnected graph
     *  Should throw an IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testMST2() throws IllegalArgumentException{
        Graph g = TestUtils.createGraph1();

        assertEquals(-1, g.minimumSpanningTree());
    }

    /**
     * Tests the 'getEdge' method on an edge that does not exist in graph
     * Return: null
     */
    @Test
    public void testGetEdge(){
        Graph g = TestUtils.createGraph2();
        Vertex v1 = new Vertex(1, "A");
        Vertex v3 = new Vertex(3, "C");

        assertEquals(null, g.getEdge(v1,v3));
    }

    /**
     * Tests 'shortestPath' method on complete graph (ie. no sub-graphs)
     * Returns a LinkedList with all the vertices in the shortest path
     */
    @Test
    public void testShortestPath(){
        Graph<Vertex, Edge<Vertex>> g = TestUtils.createGraph5();
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

    /**
     * Tests 'shortestPath' method between two vertices on separate sub-graphs
     * Should throw an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void testShortestPath2() throws IllegalArgumentException{
        Graph g = TestUtils.createGraph1();

        Vertex A = new Vertex(1, "A");
        Vertex C = new Vertex(3, "C");

        assertEquals(-1, g.shortestPath(A,C));
    }

    /**
     * Test 'diameter' method on graph 5
     * Returns 13
     * */
    @Test
    public void testDiameter() {
        Graph g = TestUtils.createGraph5();
        Vertex A = new Vertex(1, "A");
        Vertex B = new Vertex(2, "B");
        Vertex D = new Vertex(4, "D");
        Vertex F = new Vertex(6, "F");

        assertEquals(13, g.diameter());
    }

    /**
     * Tests 'createVertex' method
     * Should return true for both vertices
     */
    @Test
    public void testCreateVertex() {
        Vertex v = new Vertex(1, "A");
        assertEquals(1, v.id());
        assertEquals("A", v.name());
    }

    /**
     * Test to check if two vertices are equal both using hashcode and equals method
     */
    @Test
    public void testVertexEquals() {
        Vertex v1 = new Vertex(1, "A");
        Vertex v2 = new Vertex(5, "F");
        Vertex v3 = new Vertex(3, "B");
        Vertex v4 = new Vertex(1, "A");

        assertEquals(v1, v4);
        assertNotEquals(v1, v2);
        assert(v2.hashCode() != v3.hashCode());
        assert(v1.hashCode() == v4.hashCode());
        assertTrue(v1.equals(v4));
        assertTrue(v4.equals(v1));
    }

    /**
     * Tests 'updateName' method to check if a vertex name change was succesful
     * Should return true both times
     */
    @Test
    public void testUpdateName() {
        Vertex v1 = new Vertex(1, "name1");
        assertEquals(v1.name(), "name1");

        v1.updateName("name2");
        assertEquals(v1.name(), "name2");
    }
}

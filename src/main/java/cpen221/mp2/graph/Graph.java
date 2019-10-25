package cpen221.mp2.graph;

import java.util.*;

/**
 * Represents a graph with vertices of type V.
 *
 * @param <V> represents a vertex type
 */
public class Graph<V extends Vertex, E extends Edge<V>> implements ImGraph<V, E>, IGraph<V, E> {

    private List<V> vList;
    private Set<E> eSet;

    public Graph() {
        vList = new ArrayList<V>();
        eSet = new HashSet<E>();
    }

    /**
     * Add a vertex to the graph
     *
     * @param v vertex to add
     * @return true if the vertex was added successfully and false otherwise
     */
    public boolean addVertex(V v) {
        if (vList.contains(v)) {
            return false; //no need to add the vertex if it is already in the graph
        } else {
            vList.add(v);
            return true;
        }
    }

    /**
     * Check if a vertex is part of the graph
     *
     * @param v vertex to check in the graph
     * @return true of v is part of the graph and false otherwise
     */
    public boolean vertex(V v) {
        return vList.contains(v);
    }

    /**
     * Add an edge of the graph
     *
     * @param e the edge to add to the graph
     * @return true if the edge was successfully added and false otherwise
     */
    public boolean addEdge(E e) {
       if (eSet.contains(e)) {
           return false;
       } else {
           eSet.add(e);
           return true;
       }
    }

    /**
     * Check if an edge is part of the graph
     *
     * @param e the edge to check in the graph
     * @return true if e is an edge in the graoh and false otherwise
     */
    public boolean edge(E e) {
        return eSet.contains(e);
    }

    /**
     * Check if v1-v2 is an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return true of the v1-v2 edge is part of the graph and false otherwise
     */

    public boolean edge(V v1, V v2) {
        return eSet.contains(new Edge<V>(v1, v2));
    }

    /**
     * Determine the length on an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return the length of the v1-v2 edge if this edge is part of the graph,
     *         or -1 if the edge is not a part of the graph.
     * //TODO: Ensure this is allowed ^^^
     */
    public int edgeLength(V v1, V v2) {
        Edge target = new Edge<V>(v1, v2);

        for (Edge e : eSet) {
            if(e.equals(target)) {
                return e.length();
            }
        }

        return -1;
    }

    /**
     * Obtain the sum of the lengths of all edges in the graph
     *
     * @return the sum of the lengths of all edges in the graph
     */
    public int edgeLengthSum() {
        int sum = 0;

        for (Edge e : eSet) {
            sum += e.length();
        }

        return sum;
    }

    /**
     * Remove an edge from the graph
     *
     * @param e the edge to remove
     * @return true if e was successfully removed and false otherwise
     */
    public boolean remove(E e) {
        if (eSet.contains(e)) {
            // If the list contains e, remove it and return true.
            eSet.remove(e);
            return true;
        } else {
            // Otherwise, return false to indicate it wasn't removed.
            return false;
        }
    }

    /**
     * Remove a vertex from the graph
     *
     * @param v the vertex to remove
     * @return true if v was successfully removed and false otherwise
     */
    public boolean remove(V v) {
    	Set<E> allESet;
    	allESet = allEdges(v);

        if (vList.contains(v)) {
            return false; //return false if graph does not contain this vertex
        } else {
            vList.remove(v);

            for (Edge currE : allESet) {
                eSet.remove(currE); //Remove the edges asssociated with this vertex as well
            }
        }

        return true;
    }


    /**
     * Obtain a set of all vertices in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return a set of all vertices in the graph
     */
    public Set<V> allVertices() {
        Set<Vertex> vSet = new HashSet<Vertex>(vList);
        return (Set<V>) Collections.unmodifiableSet(vSet); //IS THIS POSSIBLE?? DOES THIS MAKE IT IMMUTABLE? (it doesn't -seth)
    }

    /**
     * Obtain a set of all vertices incident on v.
     * Access to this set **should not** permit graph mutations.
     *
     * @param v the vertex of interest
     * @return all edges incident on v
     */
    public Set<E> allEdges(V v) {
        Set<E> allESet = new HashSet<E>();

        Vertex otherVertex;

        for(int i = 0; i<vList.size(); i++){
            otherVertex = vList.get(i);
            Edge edge = new Edge(otherVertex,v);
            if(eSet.contains(edge)) {
                allESet.add((E)edge);
            }
        }

        return(Set<E>)Collections.unmodifiableSet(allESet);
    }

    /**
     * Obtain a set of all edges in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return all edges in the graph
     */
    public Set<E> allEdges() {
    	return (Set<E>) Set.copyOf(eSet);
    }

    /**
     * Obtain all the neighbours of vertex v.
     * Access to this map **should not** permit graph mutations.
     *
     * @param v is the vertex whose neighbourhood we want.
     * @return a map containing each vertex w that neighbors v and the edge between v and w.
     */
    public Map<V, E> getNeighbours(V v) {
    	Vertex currV;

        Map<V,E> neighbours = new HashMap<V,E>();
        Set<E> edges;
        edges = allEdges(v);

        for (int i = 0; i < vList.size(); i++) {
                currV = vList.get(i);
                Edge currE = new Edge(currV, v);
                if (edges.contains(currE)) {
          	      neighbours.put((V)currV, (E)currE);
                }
        }

        return neighbours;
    }

    /**
     * Compute the shortest path from source to sink
     *
     * @param source the start vertex
     * @param sink   the end vertex
     * @return the vertices, in order, on the shortest path from source to sink (both end points are part of the list)
     */
    public List<V> shortestPath(V source, V sink) {
        return null;
    }

    /**
     * Compute the minimum spanning tree of the graph.
     * See https://en.wikipedia.org/wiki/Minimum_spanning_tree
     *
     * @return a list of edges that forms a minimum spanning tree of the graph
     */
    public List<E> minimumSpanningTree() {
        return null;
    }

    /**
     * Compute the length of a given path
     *
     * @param path indicates the vertices on the given path
     * @return the length of path
     */
    public int pathLength(List<V> path) {
        return 0;
    }

    /**
     * Obtain all vertices w that are no more than a <em>path distance</em> of range from v.
     *
     * @param v     the vertex to start the search from.
     * @param range the radius of the search.
     * @return a set of vertices that are within range of v (this set does not contain v).
     */
    public Set<V> search(V v, int range) {
        return null;
    }

    /**
     * Compute the diameter of the graph.
     * <ul>
     * <li>The diameter of a graph is the length of the longest shortest path in the graph.</li>
     * <li>If a graph has multiple components then we will define the diameter
     * as the diameter of the largest component.</li>
     * </ul>
     *
     * @return the diameter of the graph.
     */
    public int diameter() {
        return 0;
    }

    /**
     * Find the edge that connects two vertices if such an edge exists.
     * This method should not permit graph mutations.
     *
     * @param v1 one end of the edge
     * @param v2 the other end of the edge
     * @return the edge connecting v1 and v2
     */
    public E getEdge(V v1, V v2) {
        return null;
    }
    
    //// add all new code above this line ////

    /**
     * This method removes some edges at random while preserving connectivity
     * <p>
     * DO NOT CHANGE THIS METHOD
     * </p>
     * <p>
     * You will need to implement allVertices() and allEdges(V v) for this
     * method to run correctly
     *</p>
     * <p><strong>requires:</strong> this graph is connected</p>
     *
     * @param rng random number generator to select edges at random
     */
    public void pruneRandomEdges(Random rng) {
        class VEPair {
            V v;
            E e;

            public VEPair(V v, E e) {
                this.v = v;
                this.e = e;
            }
        }
        /* Visited Nodes */
        Set<V> visited = new HashSet<>();
        /* Nodes to visit and the cpen221.mp2.graph.Edge used to reach them */
        Deque<VEPair> stack = new LinkedList<VEPair>();
        /* Edges that could be removed */
        ArrayList<E> candidates = new ArrayList<>();
        /* Edges that must be kept to maintain connectivity */
        Set<E> keep = new HashSet<>();

        V start = null;
        for (V v : this.allVertices()) {
            start = v;
            break;
        }
        if (start == null) {
            // nothing to do
            return;
        }
        stack.push(new VEPair(start, null));
        while (!stack.isEmpty()) {
            VEPair pair = stack.pop();
            if (visited.add(pair.v)) {
                keep.add(pair.e);
                for (E e : this.allEdges(pair.v)) {
                    stack.push(new VEPair(e.distinctVertex(pair.v), e));
                }
            } else if (!keep.contains(pair.e)) {
                candidates.add(pair.e);
            }
        }
        // randomly trim some candidate edges
        int iterations = rng.nextInt(candidates.size());
        for (int count = 0; count < iterations; ++count) {
            int end = candidates.size() - 1;
            int index = rng.nextInt(candidates.size());
            E trim = candidates.get(index);
            candidates.set(index, candidates.get(end));
            candidates.remove(end);
            remove(trim);
        }
    }
}

package cpen221.mp2.graph;

import java.util.*;

/**
 * Represents a graph with vertices of type V.
 *
 * @param <V> represents a vertex type
 */
public class Graph<V extends Vertex, E extends Edge<V>> implements ImGraph<V, E>, IGraph<V, E> {
    private List<V> vList;
    private List<E> eList;

    public Graph() {
        vList = new ArrayList<V>();
        eList = new ArrayList<E>();
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
       if (eList.contains(e)) {
           return false;
       } else {
           eList.add(e);
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
        return eList.contains(e);
    }

    /**
     * Check if v1-v2 is an edge in the graph
     *
     * @param v1 the first vertex of the edge
     * @param v2 the second vertex of the edge
     * @return true of the v1-v2 edge is part of the graph and false otherwise
     */
    public boolean edge(V v1, V v2) {
        return eList.contains(new Edge<V>(v1, v2));
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

        for (Edge e : eList) {
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

        for (Edge e : eList) {
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
        if (eList.contains(e)) {
            // If the list contains e, remove it and return true.
            eList.remove(e);
            return true;
        } else {
            // Otherwise, return false to indicate it wasn't removed since it does not exist.
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

        if (!vList.contains(v)) {
            return false; //return false if graph does not contain this vertex
        } else {
            vList.remove(v);

            for (Edge currE : allESet) {
                eList.remove(currE); //Remove the edges associated with this vertex as well
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
        return (Set<V>) vSet;
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
            if(otherVertex.equals(v)) {
                continue;
            }

            Edge edge = new Edge(otherVertex,v);
            int index = eList.indexOf(edge);
            if(index != -1) {
                allESet.add(eList.get(index));
            }
        }

        return allESet;
    }

    /**
     * Obtain a set of all edges in the graph.
     * Access to this set **should not** permit graph mutations.
     *
     * @return all edges in the graph
     */
    public Set<E> allEdges() {
    	return new HashSet<E>(eList);
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
        List<E> edges;
        edges = new ArrayList<E>(allEdges(v));

        for (int i = 0; i < vList.size(); i++) {
                currV = vList.get(i);

                if(v.equals(currV)) {
                    continue;
                }

                Edge currE = new Edge(currV, v);
                int index = edges.indexOf(currE);
                if (index != -1) {
                    neighbours.put((V)currV, edges.get(index));
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
        V current = source;
        Set<V> visited = new HashSet<>();
        HashMap<V, Integer> vertexLengths = new HashMap<>();
        // When a new preliminary weight is calculated, this hashmap
        // will store the vertex that gave it that weight as a value, and
        // itself as a key. This makes reverse iteration easy.
        HashMap<V, V> lengthSources = new HashMap<>();

        // This dummy vertex is only used when checking if a
        // vertex has been visited. Obviously, the source must
        // have been visited.
        visited.add(source);

        // Each vertex should be initialized with an infinite distance estimate.
        // However, we use negative one as a way to represent that.
        for (V v : allVertices()) {
            if(v.equals(source))
                vertexLengths.put(v,0);
            else
                vertexLengths.put(v, -1);
        }


        // This loop iterates until we find a path that connects us to the sink.
        while (!current.equals(sink)) {
            Map<V, E> neighbourhood = getNeighbours(current);

            // For each vertex we haven't yet traversed, compute
            // a preliminary distance estimate, and update if it is
            // better than the current value.
            for (V v : neighbourhood.keySet()) {
                if (!visited.contains(v)) {
                    int possibleLength = vertexLengths.get(current) + neighbourhood.get(v).length();
                    int currentLength = vertexLengths.get(v);

                    if (possibleLength < currentLength || currentLength == -1) {
                        vertexLengths.put(v, possibleLength);
                        lengthSources.put(v, current);
                    }
                }
            }

            V closest = null;
            // The starting value of shortestLength doesn't matter - it will be overridden
            // if closest is null anyway.
            int shortestLength = -1;

            // Find the neighbour vertex with the smallest distance from the source.
            for (V v : allVertices()) {
                if(visited.contains(v)) {
                    continue;
                }

                int length = vertexLengths.get(v);

                if (length == -1) {
                    continue;
                }

                if (closest == null || shortestLength > length) {
                    closest = v;
                    shortestLength = length;
                }
            }

            visited.add(closest);

            // Now, we run the loop again, but we consider our next vertex.
            current = closest;
        }

        current = sink;
        LinkedList<V> path = new LinkedList<>();

        // Reconstruct the path by reversing the visited map
        while (current != source) {
            path.addFirst(current);
            current = lengthSources.get(current);
        }

        path.addFirst(source);

        return path;
    }

    /**
     * Compute the minimum spanning tree of the graph.
     * See https://en.wikipedia.org/wiki/Minimum_spanning_tree
     *
     * @return a list of edges that forms a minimum spanning tree of the graph
     */
    public List<E> minimumSpanningTree() {
        List<List<V>> forest = new ArrayList<List<V>>();
        Set<E> pool = new HashSet<>();
        List<E> used = new ArrayList<E>();

        pool.addAll(eList);

        for (V v : vList) {
            List<V> tree = new ArrayList<>();
            tree.add(v);
            forest.add(tree);
        }

        while (forest.size() > 1) {
            int shortest = 0;
            E shortestEdge = null;

            // This finds the shortest edge that connects two trees,
            // while also removing edges that are in the same container.
            Set<E> removable = new HashSet<E>();
            for (E e : pool) {
                List<V> container1 = getContainer(forest, e.v1());
                List<V> container2 = getContainer(forest, e.v2());

                if (container1.equals(container2)) {
                    removable.add(e);
                    continue;
                } else {
                    if (e.length() < shortest || shortestEdge == null) {
                        shortest = e.length();
                        shortestEdge = e;
                    }
                }
            }

            for (E e : removable) {
                pool.remove(e);
            }

            used.add(shortestEdge);
            pool.remove(shortestEdge);

            // we have to combine the sets containing the endpoints of this edge
            List<V> mergedTree = getContainer(forest, shortestEdge.v1());
            List<V> oldTree = getContainer(forest, shortestEdge.v2());

            for (V v : oldTree) {
                mergedTree.add(v);
            }

            // Now remove the old one
            forest.remove(oldTree);
        }

        return used;
    }

    private List<V> getContainer(List<List<V>> containerSet, V vertex) {
        for (List<V> container : containerSet) {
            if (container.contains(vertex)) {
                return container;
            }
        }

        return null;
    }

    /**
     * Compute the length of a given path
     *
     * @param path indicates the vertices on the given path
     * @return the length of path
     */
    public int pathLength(List<V> path) {
        //TODO: Test me
        V last = path.get(0);
        int accumulator = 0;

        for (int i = 1; i < path.size(); i++) {
            accumulator += getEdge(last, path.get(i)).length();
            last = path.get(i);
        }

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
        int maxd = 0;
        for (V v1 : allVertices()) {
            for (V v2 : allVertices()) {
                if (v1.equals(v2)) {
                    continue;
                }

                System.out.println("Computing length for verticies " + v1.name() + " and " + v2.name());

                int length = pathLength(shortestPath(v1, v2));
                if (length > maxd) {
                    maxd = length;
                }
            }
        }

        return maxd;
    }

    /**
     * Find the edge that connects two vertices if such an edge exists.
     * This method should not permit graph mutations.
     *
     * @param v1 one end of the edge
     * @param v2 the other end of the edge
     * @return the edge connecting v1 and v2
     *         if edge does not exist, then return null
     */
    public E getEdge(V v1, V v2) {
        List<E> edgeList = new ArrayList<>(allEdges(v1));
        Edge<Vertex> edge = new Edge<>(v1, v2);

        int index = edgeList.indexOf(edge);
        if(index!=-1)
        	return edgeList.get(index);
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

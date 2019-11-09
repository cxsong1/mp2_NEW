package cpen221.mp2.graph;

/**
 * Represents a graph vertex. Each vertex has an associated id and name.
 * No two vertices in the same graph should have the same id.
 *
 * AF:
 *    Represents a named vertex with an ID on an undirected weighted graph.
 * RI:
 *    All verticies must be created with distinct IDs
 *    IDs cannot be changed, and are stored as private ints
 *    Names are stored as strings, and are mutable
 *    Verticies with the same ID and name will have the same hashcode and are equal
 *
 */
public class Vertex {
    private final int id;
    private String name;

    /**
     * Create a new vertex
     *
     * @param id   is a numeric identifier for the vertex
     * @param name is a name for the vertex
     */
    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Vertex) {
            Vertex other = (Vertex) o;
            if (other.id == this.id && other.name.equals(this.name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + id;
    }

    public int id() {
        return id;
    }

    /**
     * Obtain the vertex name
     *
     * @return the vertex name
     */
    public String name() {
        return name;
    }

    /**
     * Update the vertex name
     *
     * @param name the new vertex name
     */
    public void updateName(String name) {
        this.name = name;
    }

    //// --- any new methods, if necessary, go below this link --- ////

}

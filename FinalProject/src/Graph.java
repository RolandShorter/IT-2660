import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Graph {
    int edges;
    // Maps a vertex to an ArrayList of all edges that start from that vertex
    private HashMap<Vertex, ArrayList<Edge>> fromEdges;

    // Maps a vertex to an ArrayList of all edges that go to that vertex
    private HashMap<Vertex, ArrayList<Edge>> toEdges;

    public Graph() {
        fromEdges = new HashMap<Vertex, ArrayList<Edge>>();
        toEdges = new HashMap<Vertex, ArrayList<Edge>>();
    }

    public Vertex addVertex(String newVertexLabel) {
        // Create the new Vertex object
        Vertex newVertex = new Vertex(newVertexLabel);

        // Every vertex must exist as a key in both maps
        fromEdges.put(newVertex, new ArrayList<Edge>());
        toEdges.put(newVertex, new ArrayList<Edge>());

        return newVertex;
    }

    public Edge addDirectedEdge(Vertex fromVertex, Vertex toVertex, double weight) {
        // Don't add the same edge twice
        if (hasEdge(fromVertex, toVertex)) {
            return null;
        }

        // Create the Edge object
        Edge newEdge = new Edge(fromVertex, toVertex, weight);

        // Add the edge to the appropriate list in both maps
        fromEdges.get(fromVertex).add(newEdge);
        toEdges.get(toVertex).add(newEdge);
        edges++;

        return newEdge;
    }

    public int getEdges() {
        return edges;
    }

    public Edge[] addUndirectedEdge( Vertex vertexA, Vertex vertexB, double weight) {
        Edge edge1 = addDirectedEdge(vertexA, vertexB, weight);
        Edge edge2 = addDirectedEdge(vertexB, vertexA, weight);
        return new Edge[] { edge1, edge2 };
    }

    // Returns the collection of edges with the specified fromVertex
    public Collection<Edge> getEdgesFrom(Vertex fromVertex) {
        return fromEdges.get(fromVertex);
    }

    // Returns the collection of edges with the specified toVertex
    public Collection<Edge> getEdgesTo(Vertex toVertex) {
        return toEdges.get(toVertex);
    }

    // Returns a vertex with a matching label, or null if no such vertex exists
    public Vertex getVertex(String vertexLabel) {
        // Search the collection of vertices for a vertex with a matching label
        for (Vertex vertex : getVertices()) {
            if (vertex.label.equals(vertexLabel)) {
                return vertex;
            }
        }
        return null;
    }

    // Returns the collection of all of this graph's vertices
    public Collection<Vertex> getVertices() {
        return fromEdges.keySet();
    }

    // Returns true if this graph has an edge from fromVertex to toVertex
    public boolean hasEdge(Vertex fromVertex, Vertex toVertex) {
        if (!fromEdges.containsKey(fromVertex)) {
            // fromVertex is not in this graph
            return false;
        }

        // Search the list of edges for an edge that goes to toVertex
        ArrayList<Edge> edges = fromEdges.get(fromVertex);
        for (Edge edge : edges) {
            if (edge.toVertex == toVertex) {
                return true;
            }
        }

        return false;
    }

    void printGraph() {
        List<ArrayList<Edge>> edges = new ArrayList<>(fromEdges.values());
        edges.forEach(System.out::println);
    }
}

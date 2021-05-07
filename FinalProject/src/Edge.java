

public class Edge {
    public Vertex fromVertex;
    public Vertex toVertex;
    public double weight;

    public Edge( Vertex from, Vertex to, double weight) {
        fromVertex = from;
        toVertex = to;
        this.weight = weight;
    }

    public Vertex getFromVertex() {
        return fromVertex;
    }

    public Vertex getToVertex() {
        return toVertex;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return fromVertex.label + " -> " + toVertex.label + " (" + weight + ")";
    }

}

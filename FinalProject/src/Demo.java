import java.time.Instant;
import java.util.*;

/**
 * @author Roland
 * Date: 5/5/21
 * Time: 2:44 PM
 */
public class Demo {
    Vertex start, target;
    Vertex[] vertices;
    public static final int MAX_VERTICES = 10;
    public static final int MAX_VALUE = 1000;
    public static final int MAX_CONNECTIONS = 5;
    public static final Random rnd = new Random(Instant.now().getEpochSecond());

    public static void main(String[] args) {
        new Demo().go();
    }
    private void go() {
        Graph g = new Graph();
        createFirstGraph(g);

        System.out.printf("Searching from %s for %s.\n", start.label, target.label);

        SearchInfo bfsInfo = BFS.bfs(g, start, target);
        System.out.println("\t" + bfsInfo);

        SearchInfo dfsInfo = DFS.dfs(g, start, target);
        System.out.println("\t" + dfsInfo);


        // Run Dijkstra's algorithm first.
        HashMap<Vertex, PathVertexInfo> infoMap =
            Dijkstra.dijkstraShortestPath(g, start);

        // Display shortest path for each vertex from vertexA.
        for (Vertex vertex : vertices) {
            PathVertexInfo info = infoMap.get(vertex);
            if (info.predecessor == null && vertex != start) {
                System.out.printf("A to %s: no path exists%n", vertex.label);
            }
            else {
                System.out.printf("A to %s: %s (total weight: %d)%n", vertex.label,
                    Dijkstra.getShortestPath(start, vertex, infoMap), (int)info.distance);
            }
        }
    }

    void createFirstGraph( Graph g ) {
        int i = 0;
        vertices = new Vertex[7];
        Vertex vertexA = g.addVertex("A"); vertices[i++] = vertexA;
        Vertex vertexB = g.addVertex("B"); vertices[i++] = vertexB;
        Vertex vertexC = g.addVertex("C"); vertices[i++] = vertexC;
        Vertex vertexD = g.addVertex("D"); vertices[i++] = vertexD;
        Vertex vertexE = g.addVertex("E"); vertices[i++] = vertexE;
        Vertex vertexF = g.addVertex("F"); vertices[i++] = vertexF;
        Vertex vertexG = g.addVertex("G"); vertices[i] = vertexG;

        g.addUndirectedEdge(vertexA, vertexB, 8);
        g.addUndirectedEdge(vertexA, vertexC, 7);
        g.addUndirectedEdge(vertexA, vertexD, 3);
        g.addUndirectedEdge(vertexB, vertexE, 6);
        g.addUndirectedEdge(vertexC, vertexD, 1);
        g.addUndirectedEdge(vertexC, vertexE, 2);
        g.addUndirectedEdge(vertexD, vertexF, 15);
        g.addUndirectedEdge(vertexD, vertexG, 12);
        g.addUndirectedEdge(vertexE, vertexF, 4);
        g.addUndirectedEdge(vertexF, vertexG, 1);

        start = vertexA; target = vertexG;
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestClass {
    private Graph g;
    private Vertex start;

    @BeforeEach
    void setUp() {
        Demo demo = new Demo();
        g = new Graph();
        demo.createFirstGraph(g);
        start = demo.start;
    }

    @Test
    void testDfs() {
        SearchInfo dfs = DFS.dfs(g, start, new Vertex("G"));
        System.out.println(dfs);
    }
    @Test
    void testBFS() {
        SearchInfo bfs = BFS.bfs(g, start, new Vertex("G"));
        System.out.println(bfs);
    }
}
import java.util.*;

public class BFS {
    // BFS - Breadth first search
    public static SearchInfo bfs( Graph graph, Vertex start, Vertex searchKey) {
        System.out.printf("bfs: %s\t", searchKey);
        Queue<Vertex> queue = new LinkedList<>();
        SearchInfo bfsInfo = new SearchInfo();
        ArrayList<Vertex> visited = new ArrayList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex v = queue.poll();
            visited.add(v);
            bfsInfo.incNodesSearch();
            if (v.label.equals(searchKey.label)) {
                bfsInfo.setSuccess();
                break;
            }
            graph.getEdgesFrom(v).stream().map(Edge::getToVertex).forEach(queue::add);
        }
        bfsInfo.setPath(visited.size() - 1);
        return bfsInfo;
    }
}
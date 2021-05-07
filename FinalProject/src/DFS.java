import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    // DFS - Depth first search
    public static SearchInfo dfs( Graph graph, Vertex start, Vertex searchKey) {
        System.out.printf("dfs: %s\t", searchKey);
        Stack<Vertex> stack = new Stack<>();
        SearchInfo dfsInfo = new SearchInfo();
        ArrayList<Vertex> visited = new ArrayList<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            visited.add(v);
            dfsInfo.incNodesSearch();
            if (v.label.equals(searchKey.label)) {
                dfsInfo.setSuccess();
                break;
            }
            graph.getEdgesFrom(v).stream().map(Edge::getToVertex).forEach(stack::push);
        }
        dfsInfo.setPath(visited.size() - 1);
        return dfsInfo;
    }
}
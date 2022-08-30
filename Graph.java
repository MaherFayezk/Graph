import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph<V> {
    int numberOfVertices;
    HashMap<V, List<V>> graph;

    Graph() {
        this.numberOfVertices = 0;
        this.graph = new HashMap<>();
    }

    public void addVertex(V vertex) {
        this.graph.put(vertex, new ArrayList<>());
        this.numberOfVertices++;
    }

    private boolean isVertexAdjacent(List<V> adjacenyList, V adjacentVertex) {
        boolean isAdjacent = adjacenyList.stream().filter(vertex -> vertex == adjacentVertex).findFirst().isPresent();
        return isAdjacent;
    }

    public void addEdge(V vertex1, V vertex2) {
        List<V> adjacenyList = this.graph.get(vertex1);

        if (!isVertexAdjacent(adjacenyList, vertex2)) {
            this.graph.get(vertex1).add(vertex2);
        }
        adjacenyList = this.graph.get(vertex2);
        if (!isVertexAdjacent(adjacenyList, vertex1)) {
            this.graph.get(vertex2).add(vertex1);
        }

    }

    public void showConnections() {
        this.graph.forEach((v, list) -> {
            System.out.print(v + "----->");
            list.forEach(node -> {
                System.out.print(node + " ");
            });
            System.out.println();
        });
    }
}
package Chapter9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph_AdjacencyList {

	Map<Integer, List<Integer>> adjacencyList;
	int vertexCount;

	public Graph_AdjacencyList(int vertexCount) {
		this.vertexCount = vertexCount;
		adjacencyList = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= vertexCount; i++)
			adjacencyList.put(i, new LinkedList<Integer>());
	}

	public void setEdge(int source, int destination) {
		if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
			List<Integer> slist = adjacencyList.get(source);
			slist.add(destination);
			List<Integer> dlist = adjacencyList.get(destination);
			dlist.add(source);
		}
		return;
	}

	public List<Integer> getEdge(int source) {
		if (adjacencyList.containsKey(source)) {
			return adjacencyList.get(source);
		}
		return null;

	}

	public void printGraph() {
		System.out.println("The given Adjacency List for the graph \n");
		for (int i = 1; i <= vertexCount; i++) {
			System.out.print(i + "->");
			List<Integer> edgeList = adjacencyList.get(i);
			for (int j = 1;; j++) {
				if (j != edgeList.size()) {
					System.out.print(edgeList.get(j - 1) + "->");
				} else {
					System.out.print(edgeList.get(j - 1));
					break;
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph_AdjacencyList g = new Graph_AdjacencyList(5);

		g.setEdge(1, 3);
		g.setEdge(2, 3);
		g.setEdge(4, 3);
		g.setEdge(4, 5);
		g.printGraph();

	}

}

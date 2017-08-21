package Chapter9;

import java.util.Arrays;

public class Graph {

	boolean adjacencyMatrix[][];
	int vertexCount;

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount;
		adjacencyMatrix = new boolean[vertexCount][vertexCount];
	}

	public void addEdge(int row, int col) {
		if (row < 0 || adjacencyMatrix.length <= row || col < 0 || adjacencyMatrix[row].length <= col)
			return;
		adjacencyMatrix[row][col] = true;
		adjacencyMatrix[col][row] = true;
	}

	public void removeEdge(int row, int col) {
		if (row < 0 || adjacencyMatrix.length <= row || col < 0 || adjacencyMatrix[row].length <= col)
			return;
		adjacencyMatrix[row][col] = false;
		adjacencyMatrix[col][row] = false;
	}

	public boolean isEdge(int row, int col) {
		if (row < 0 || adjacencyMatrix.length <= row || col < 0 || adjacencyMatrix[row].length <= col)
			return false;
		return adjacencyMatrix[row][col];
	}

	public void printGraph() {
		for (int i = 0; i < adjacencyMatrix.length; i++)
			System.out.println(Arrays.toString(adjacencyMatrix[i]));
	}

	public static void main(String args[]) {

		Graph g = new Graph(4);
		g.addEdge(1, 2);
		g.printGraph();
	}
}

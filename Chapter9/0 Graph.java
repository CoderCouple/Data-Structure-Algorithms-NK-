package Chapter9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {

	public int maxVertices = 20;
	public List<Vertex> vertexList;
	public int adjacentMatrix[][];
	public int vertexCount;
	public Stack theStack;

	public Graph() {
		vertexList = new ArrayList<Vertex>();
		adjacentMatrix = new int[maxVertices][maxVertices];
		vertexCount = 0;
		theStack = new Stack();
	}

	public void addVertex(Vertex vertex) {
		vertexList.add(vertex);
		vertexCount++;
	}

	public void addEdge(Vertex source, Vertex destination) {
		adjacentMatrix[vertexList.indexOf(source)][vertexList.indexOf(destination)] = 1;
		adjacentMatrix[vertexList.indexOf(destination)][vertexList.indexOf(source)] = 1;
	}

	public void displayVertex(Vertex vertex) {
		System.out.println("Name : " + vertex.name);
		System.out.println("IsVisited : " + vertex.isVisited);
	}

	public void dfs() {
		Vertex temp = vertexList.get(0);
		temp.isVisited = true;
		theStack.push(temp);
		displayVertex(temp);

		while (!theStack.isEmpty()) {
			Vertex v = getAdjacentUnvisitedVertex((Vertex) theStack.peek());
			if (v == null)
				theStack.pop();

			else {
				v.isVisited = true;
				displayVertex(v);
				theStack.push(v);
			}
		}
	}

	public Vertex getAdjacentUnvisitedVertex(Vertex vertex) {
		for (int i = 0; i < vertexList.size(); i++)
			if (adjacentMatrix[vertexList.indexOf(vertex)][i] == 1 && vertexList.get(i).isVisited == false)
				return vertexList.get(i);
		return null;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Vertex v1 = new Vertex("V1");
		Vertex v2 = new Vertex("V2");
		Vertex v3 = new Vertex("V3");
		Vertex v4 = new Vertex("V4");
		Vertex v5 = new Vertex("V5");
		
		g.addVertex(v1);
		g.addVertex(v2);
		g.addVertex(v3);
		g.addVertex(v4);
		g.addVertex(v5);
		
		g.addEdge(v1, v2);
		g.addEdge(v2, v3);
		g.addEdge(v3, v4);
		g.addEdge(v4, v5);
		g.addEdge(v1, v4);
		g.addEdge(v2, v4);
		g.addEdge(v3, v5);
		
		g.dfs();

	}

}

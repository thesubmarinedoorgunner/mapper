package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class staticGeodesic {

	public staticGeodesic() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<Node> getCurrentNodeSet(ArrayList<Node> nodes) {return nodes; }
	public static ArrayList<Edge> getCurrentEdges(ArrayList<Edge> edges) { return edges; }

	public static float Dijkstra(ArrayList<Node> nodes, ArrayList<Edge> edges, Node node)
	{
		float steps = -1;
		
		// should be arraylist ?
//		int dist[] = new int[nodes.size()];
//		int prev[] = new int[edges.size()];
		
		// if I use GeeksforGeeks, then I need a 2D array ?
		int matrix[][] = new int[nodes.size()][nodes.size()];
		
		PriorityQueue PQ = new PriorityQueue();
//		for (int i = 0; i < nodes.size(); i++)
//		{
//			for (int j = 0; j < nodes.size(); j++)
//			{
//				graph[i][j] = 0;
//			}
//		}
		
		
//		Arrays.fill(matrix, -1);
		
		for ( int[] row : matrix )
		{
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		
//		for (int i = 0; i < nodes.size(); i++)
//		{
//			for (int j = 0; j < nodes.size(); j++)
//			{
//				System.out.print(matrix[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		Node[] id = new Node[nodes.size()];
		
		// maybe I need to return the dist[] and prev[] ?
		// I know you can't return two things, but the pseudocode says I need to
		return steps;
	}

}

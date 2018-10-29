package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.Comparator;

public class Dijkstra {

	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	public ArrayList<Edge> path = new ArrayList<Edge>();
	
	public Dijkstra() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
	}
	
	public Dijkstra(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public static class compare implements Comparator<Node>
	{

		@Override
		public int compare(Node node1, Node node2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
}

package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	private ArrayList<Edge> path = new ArrayList<Edge>();
	PriorityQueue<Node> PQ;
	
	// naive
	ArrayList<Edge> visited = new ArrayList<Edge>();
	
	private Node base;
	
	public Dijkstra() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		PQ = new PriorityQueue<Node>();
		this.base = null;
	}
	
	public Dijkstra(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base)
	{
		this.nodes = nodes;
		this.edges = edges;
		this.PQ = new PriorityQueue<Node>(nodes.size(), new compare() );
		this.base = base;
	}
	
	public ArrayList<Edge> getPath() { return this.path; }
	
	public void setNode(ArrayList<Node> nodes) { this.nodes = nodes; }
	public void setEdge(ArrayList<Edge> edges) { this.edges = edges; }
	public void setPQ(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base) { this.PQ = new PriorityQueue(nodes.size(), new compare() ); }
	

	public class compare implements Comparator<Node>
	{
		public int compare(Node node1, Node node2) {
			
			if (base.EuclideanDistance(node1) > base.EuclideanDistance(node2) ) { return 1; }
			if (base.EuclideanDistance(node1) < base.EuclideanDistance(node2) ) { return -1; }

			return 0;	
		}
	}
	
	// naive find min
	// this doesn't find min. Need Euclidean distance
	Edge getMinEdge(Node target)
	{
		int count = 0;
		Edge min = null;
		
		// this for loop is incorrect
		for (Edge edge : edges)
		{
			Edge potential = null;
			if ( (edge.getp0() == base && edge.getp1() == target) 
				|| (edge.getp0() == target && edge.getp1() == base)	)
			{
				potential = edge;
				break;
			}
		}
		
		// shortest min edge already exists
//		for (Edge edge : path)
//		{
//			if (edge == potential)
//			{
//				return null;
//			}
//		}
		
		return min;
	}
	
	
	
}

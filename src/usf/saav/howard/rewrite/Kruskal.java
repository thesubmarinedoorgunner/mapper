package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

// let's see if this works without union
public class Kruskal {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	private Node base;
	
	private ArrayList<Node> queue;
	private ArrayList<Edge> path = new ArrayList<Edge>();
	
	private HashMap<Node, KruskalContainer> container;
	
	public Kruskal(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base) {
		
		this.nodes = nodes;
		this.edges = new ArrayList<Edge>(edges);
		this.base = base;
		this.queue = new ArrayList<Node>(this.nodes);
		
		// might not need this
//		this.container = new HashMap<Node, KruskalContainer>();
		
		calculateKruskal();
		
	}

	public ArrayList<Edge> getPath() { return this.path; }
	
	public void setNode(ArrayList<Node> nodes) { this.nodes = nodes; }
	public void setEdge(ArrayList<Edge> edges) { this.edges = edges; }
	
	public void calculateKruskal()
	{
		while ( !queue.isEmpty() )
		{
			Edge min = findMin();
			
			if ( !queue.contains( min.getp0() ) && !queue.contains( min.getp1() ) )
			{
				continue;
			}
			else
			{
				if ( queue.contains( min.getp0() ) )
				{
					queue.remove( min.getp0() );
				}
				if ( queue.contains( min.getp1() ) )
				{
					queue.remove( min.getp1() );
				}
				path.add( min );
			}
		}
	}
	
	public Edge findMin()
	{
		Edge isMin = null;
		float min = Float.MAX_VALUE;
		
		for (Edge edge : edges)
		{
			if ( edge.getEuclideanDistance() < min )
			{
				min = edge.getEuclideanDistance();
				isMin = edge;
			}
		}
		
		return isMin;
		
	}
	
	public class compare implements Comparator<Edge>
	{
		public int compare(Edge edge1, Edge edge2) {
			
//			if (base.EuclideanDistance(node1) > base.EuclideanDistance(node2) ) { return 1; }
//			if (base.EuclideanDistance(node1) < base.EuclideanDistance(node2) ) { return -1; }
			if ( edge1.getEuclideanDistance() > edge2.getEuclideanDistance() ) { return 1; }
			else if ( edge1.getEuclideanDistance() < edge2.getEuclideanDistance() ) { return -1; }

			return 0;	
		}
	}
	
	public class KruskalContainer
	{
		private float dist;
		private Node prev;
		private Edge edge;
		
		KruskalContainer()
		{
			this.dist = Float.MAX_VALUE;
			this.prev = null;
			this.edge = null;
		}
		KruskalContainer(float zero)
		{
			this.dist = zero;
			this.prev = null;
			this.edge = edge;
		}
		
		public float getDist() { return this.dist; }
		public void setDist(float dist) { this.dist = dist; }
		
		public Node getPrev() { return this.prev; }
		public void setPrev(Node prev) { this.prev = prev; }
		
		public Edge retrieveEdge() { return this.edge; }
		public void updateEdge(Edge edge) { this.edge = edge; }
		
	}
}

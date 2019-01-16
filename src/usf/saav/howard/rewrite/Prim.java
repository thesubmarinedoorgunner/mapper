package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.HashMap;

public class Prim {

	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	private ArrayList<Edge> path = new ArrayList<Edge>();
	private ArrayList<Node> queue;
	
	private Node base;
	
	public HashMap<Node, PrimContainer> container;
	
	public Prim(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base) {
		
		this.nodes = nodes;
		this.edges = new ArrayList<Edge>(this.edges);
		this.base = base;
		this.queue = new ArrayList<Node>(this.nodes);
		
		// might not need this
		this.container = new HashMap<Node, PrimContainer>();
		
		
	}

	public ArrayList<Edge> getPath() { return this.path; }
	
	public void setNode(ArrayList<Node> nodes) { this.nodes = nodes; }
	public void setEdge(ArrayList<Edge> edges) { this.edges = edges; }
	
	
	public void calculatePrim()
	{
		Node u = this.base;
		while ( !queue.isEmpty() )
		{
			ArrayList<Edge> neighbors = getNeighbors(u);
			
			for (Edge edge : neighbors)
			{
				if ( !queue.contains( edge.getp0() ) && !queue.contains( edge.getp1() ) )
				{
					neighbors.remove( edge );
				}
			}
			
			Edge min = findMinEdge(neighbors);
			this.path.add( min );
			
			if ( min.getp0() == u ) 
			{
				queue.remove(u);
				u = min.getp1();
			}
			if ( min.getp1() == u )
			{
				queue.remove( u );
				u = min.getp0();
			}
		}
	}
	
	public ArrayList<Edge> getNeighbors(Node u)
	{
		ArrayList<Edge> neighbors = new ArrayList<Edge>();
		
		for (Edge edge : edges)
		{
			if (edge.getp0() == u || edge.getp1() == u)
			{
				neighbors.add(edge);
			}
		}
		
		return neighbors;
	}
	
	public Edge findMinEdge(ArrayList<Edge> edges)
	{
		float min = Float.MAX_VALUE;
		Edge isMin = null;
		
		for (Edge edge : edges)
		{
			if (edge.getEuclideanDistance() < min)
			{
				min = edge.getEuclideanDistance();
				isMin = edge;
			}
		}
		return isMin;
	}
	
	
	public class PrimContainer
	{
		private float dist;
		private Node prev;
		private Edge edge;
		
		PrimContainer()
		{
			this.dist = Float.MAX_VALUE;
			this.prev = null;
			this.edge = null;
		}
		PrimContainer(float zero)
		{
			this.dist = zero;
			this.prev = null;
			this.edge = null;
		}
		
		public float getDist() { return this.dist; }
		public void setDist(float dist) { this.dist = dist; }
		
		public Node getPrev() { return this.prev; }
		public void setPrev(Node prev) { this.prev = prev; }
		
		
		public Edge retrieveEdge() { return this.edge; }
		public void updateEdge(Edge edge) { this.edge = edge; }
	}
}

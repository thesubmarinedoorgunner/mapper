package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {

	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	
	public ArrayList<Edge> path = new ArrayList<Edge>();
	//private ArrayList<Node> previous = new ArrayList<Node>();
	//PriorityQueue<Node> PQ;
	
	//int dist[];
	public HashMap<Node, Integer> dist = new HashMap<Node, Integer>();
	public HashMap<Node, Node> previous = new HashMap<Node, Node>();
	ArrayList<Node> queue;
	
	// naive
	//ArrayList<Edge> visited = new ArrayList<Edge>();
	
	private Node base;
	
//	public Dijkstra() {
//		nodes = new ArrayList<Node>();
//		edges = new ArrayList<Edge>();
//		//PQ = new PriorityQueue<Node>();
//		this.base = null;	
//	}
	
	public Dijkstra(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base)
	{
		this.nodes = nodes;
		this.edges = edges;
		this.base = base;
		//this.PQ = new PriorityQueue<Node>(nodes.size(), new compare() );
		//this.dist = new int[ nodes.size() ];
		this.queue = new ArrayList<Node>(this.nodes);
		System.out.println("Queue was set. Passed all assignments.");
		setInfinity();
		System.out.println("Infinity was set.");
		setNull();
		System.out.println("Null was set");
		calculateDijkstra();
		System.out.println("Dijkstra was calculated.");
		setPath();
		System.out.println("Path was set.");

	}
	
	public ArrayList<Edge> getPath() { return this.path; }
	
	public void setNode(ArrayList<Node> nodes) { this.nodes = nodes; }
	public void setEdge(ArrayList<Edge> edges) { this.edges = edges; }
	//public void setPQ(ArrayList<Node> nodes, ArrayList<Edge> edges, Node base) { this.PQ = new PriorityQueue(nodes.size(), new compare() ); }
	
	
	public void setInfinity() 
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			if (nodes.get(i) == base)
			{
				dist.put(nodes.get(i), 0);
				continue;
			}
			this.dist.put(nodes.get(i), Integer.MAX_VALUE);
		}
	}
	
	public void setNull()
	{
		for (int i = 0; i < nodes.size(); i++)
		{
			this.previous.put(nodes.get(i), null);
		}
	}
	
	public void calculateDijkstra()
	{
		
		while ( !queue.isEmpty() )
		{
			Node u = findMin();
			//System.out.println("But we're still here ?");
			System.out.println( queue.size() );
			ArrayList<Edge> neighbors = getNeighbors( u );
			
			if ( neighbors.size() == 0 )
			{
				queue.remove(u);
				continue;
			}
			
			
			for (Edge edge : neighbors)
			{
				Node v = null;
				if ( edge.getp0() == u ) { v = edge.getp1(); }
				else if ( edge.getp1() == u) { v = edge.getp0(); }

				float alt = Integer.valueOf( dist.get( u ) ) + edge.getEuclideanDistance();
				
				if (alt < Integer.valueOf( dist.get(v)) )
				{
					alt = Math.round(alt);
					//dist.put(v, (int) alt);
					dist.replace(v, dist.get(v), (int)alt);
					previous.replace(v, previous.get(v), u);
				}
			}
			
			neighbors.clear();
			queue.remove(u);
		}
	}
	
	
	public Node findMin()
	{
		int min = Integer.MAX_VALUE;
		Node isMin = null;
		for (int i = 0; i < queue.size(); i++)
		{
			if ( Integer.valueOf( dist.get( queue.get(i) ) ) == Integer.MAX_VALUE) { continue; }
			if ( Integer.valueOf( dist.get( queue.get(i) ) ) < min )
			{
				min = Integer.valueOf( dist.get( queue.get(i) ) );
				isMin = queue.get(i);
			}
		}
		
		if ( min == Integer.MAX_VALUE) { return queue.get(0); }
		
		return isMin;
	}
	
	public ArrayList<Edge> getNeighbors(Node u)
	{
		ArrayList<Edge> neighbors = new ArrayList<Edge>();
		
		for (Edge edge : edges)
		{
			if ( edge.getp0() == u && queue.contains(edge.getp1() ))
			{	
				neighbors.add(edge);
//				for (Node node : queue)
//				{
//					if ( queue.contains(edge.getp1()) ) { neighbors.add(edge); }
//				}
//				//else
//				continue;
			}
			if ( edge.getp1() == u && queue.contains(edge.getp0() ))
			{
				neighbors.add(edge);
//				for (Node node : queue)
//				{
//					if ( queue.contains(edge.getp0()) ) { neighbors.add(edge); }
//				}
//				// else
//				continue;
			}
		}
		return neighbors;
	}
	
	public void setPath()
	{
		Iterator iterate = previous.entrySet().iterator();
		while ( iterate.hasNext() )
		{
			HashMap.Entry pair = (HashMap.Entry)iterate.next();
			
			if ( pair.getValue() == null )
			{
				iterate.remove(); // avoids a ConcurrentModificationException
				continue;
			}
			path.add( findEdge( (Node)pair.getKey(), (Node)pair.getValue()) );
			
		}
	}
	
	public Edge findEdge(Node u, Node v)
	{
		Edge found = null;
		
		for (Edge edge : edges)
		{
			if ( (u == edge.getp0() && v == edge.getp1()) || (u == edge.getp1() && v == edge.getp0()) );
			{
				found = edge;
				break;
			}
		}
		
		return found;
	}
	
	
	
	
	
	
	
	
	

	public class compare implements Comparator<Node>
	{
		public int compare(Node node1, Node node2) {
			
			if (base.EuclideanDistance(node1) > base.EuclideanDistance(node2) ) { return 1; }
			if (base.EuclideanDistance(node1) < base.EuclideanDistance(node2) ) { return -1; }

			return 0;	
		}
	}
	
	
	
	/*
	
	// don't need this
	// naive find min
	// this doesn't find min. Need Euclidean distance
	Edge getMinEdge(Node base, Node target)
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
	
	*/
	
}

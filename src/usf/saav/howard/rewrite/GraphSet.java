package usf.saav.howard.rewrite;

import java.util.ArrayList;

import processing.core.PApplet;

public class GraphSet {
	
	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	public Dijkstra dijkstra = null;
	
	GraphSet()
	{
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	GraphSet(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public void addNode(Node node) { nodes.add(node); }
	public void addEdge(Edge edge) { edges.add(edge); }

	public void DijkstraSet(Node u)
	{
		//long start = System.currentTimeMillis(); 
		long start = System.nanoTime();
		
		dijkstra = new Dijkstra(this.nodes, this.edges, u);
		
		//long end = System.currentTimeMillis();
		long end = System.nanoTime();
		
		System.out.println("Takes " + (end- start) + "nanoseconds to run Dijkstra's");
				
	}
	// save and load a JSON in here
	
	// Dijkstra's algorithm here
	
//	public Node getNode()
//	{
//		
//	}
	
	// I think Dr. Rosen said not to do this
//	public void setGraph(ArrayList<Node> nodes, ArrayList<Edge> edges)
//	{
//		this.nodes = nodes;
//		this.edges = edges;
//	}
//	
//	public void setNodes(ArrayList<Node> nodes)
//	{
//		this.nodes = nodes;
//	}
//	public ArrayList<Node> getNodes()
//	{
//		return this.nodes;
//	}
//	
//	public void setEdges(ArrayList<Edge> edges)
//	{
//		this.edges = edges;
//	}
//	public ArrayList<Edge> getEdges()
//	{
//		return this.edges;
//	}

	public void draw(PApplet p)
	{
		for (Node temp : nodes)
		{
			temp.draw(p);
//			try
//			{
//				if ( !nodes.isEmpty() )
//					staticGeodesic.Dijkstra(nodes, edges, temp);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
		}
		for (Edge temp : edges)
		{
			try
			{
//				if ( dijkstra != null && dijkstra.path.contains(temp) )
//				{
//					temp.drawHeavy(p);
////				}
//				else { temp.draw(p); }
				temp.draw(p);
			}
			catch( Exception e)
			{
				e.printStackTrace();
			}
			
		}
		// needed this try catch block and this separate print
		try
		{
			for (Edge temp : dijkstra.path)
			{
				temp.drawHeavy(p);
			}
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
}

package usf.saav.howard.rewrite;

import java.util.ArrayList;

import processing.core.PApplet;

public class GraphSet {
	
	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	
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
	
	public void addNode(Node node)
	{
		nodes.add(node);
	}
	
	public void addEdge(Edge edge)
	{
		edges.add(edge);
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
			try
			{
				if ( !nodes.isEmpty() )
					staticGeodesic.Dijkstra(nodes, edges, temp);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		for (Edge temp : edges)
		{
			temp.draw(p);
		}
		
		
	}
	
}

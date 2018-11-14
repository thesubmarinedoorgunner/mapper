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
		long start = System.currentTimeMillis(); 
		//long start = System.nanoTime();
		
		dijkstra = new Dijkstra(this.nodes, this.edges, u);
		
		long end = System.currentTimeMillis();
		//long end = System.nanoTime();
		
		System.out.println("Takes " + (end- start) + "ms to run Dijkstra's");
				
	}
	
	/* only for testing
	
	public void generateRandom(PApplet p)
	{
		try
		{
			for (int i = 0; i < 10; i++)
			{
				nodes.add( new Node ( p.random(100, p.width -100), p.random(100, p.height - 100), nodes.size() ));
			}
			
			for (int i = 0; i < 10; i++)
			{
				edges.add( new Edge( nodes.get( (int)p.random(0,nodes.size()-1) ), nodes.get( (int)p.random(0,nodes.size()-1 )) ));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	*/
	
	
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
		try
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
	
	//				if ( dijkstra != null && dijkstra.path.contains(temp) )
	//				{
	//					temp.drawHeavy(p);
	////				}
	//				else { temp.draw(p); }
					temp.draw(p);
	
				
			}
			// needed this try catch block and this separate print
	
			for (Edge temp : dijkstra.path)
			{
				temp.drawHeavy(p);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	
}

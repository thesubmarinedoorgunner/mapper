package usf.saav.howard.rewrite;

import java.util.ArrayList;

import processing.core.PApplet;

public class GraphSet {
	
	protected ArrayList<Node> nodes;
	protected ArrayList<Edge> edges;
	
	GraphSet()
	{
		this.nodes = null;
		this.edges = null;
	}
	GraphSet(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	protected void setGraph(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	protected void setNodes(ArrayList<Node> nodes)
	{
		this.nodes = nodes;
	}
	protected ArrayList<Node> getNodes()
	{
		return this.nodes;
	}
	
	protected void setEdges(ArrayList<Edge> edges)
	{
		this.edges = edges;
	}
	protected ArrayList<Edge> getEdges()
	{
		return this.edges;
	}

	protected void draw(PApplet p)
	{
		for (Node temp : nodes)
		{
			temp.draw(p);
		}
		for (Edge temp : edges)
		{
			temp.draw(p);
		}
	}
	
}

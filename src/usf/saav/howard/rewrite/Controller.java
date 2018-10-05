package usf.saav.howard.rewrite;

import java.util.ArrayList;
import processing.core.PApplet;

public abstract class Controller {

	// because everything is pass by reference in Java
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	
	// movement variables
	Node selNode = null;
	Edge selEdge = null;
	
	Controller()
	{
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	
	Controller (ArrayList<Node> nodes, ArrayList<Edge> edge)
	{
		this.nodes = nodes;
		this.edges = edges;
	}

	public void setController(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public void mousePressed(PApplet p)
	{
		float thresh = 10;
		
		for (Node temp : nodes)
		{
			float d = temp.EuclideanDistance(p.mouseX, p.mouseY);
			
		}
	}
	public void mouseReleased()
	{
		
	}
}

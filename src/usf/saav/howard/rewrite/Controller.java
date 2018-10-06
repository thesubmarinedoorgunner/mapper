package usf.saav.howard.rewrite;

import java.util.ArrayList;
import processing.core.PApplet;

public class Controller {

	// because everything is pass by reference in Java
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	
	Node p0 = null;
	// movement variables
	Node selNode = null;
	Edge selEdge = null; // don't think I need this because pass by reference
	
	Controller()
	{
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
	}
	
	Controller (ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}

	public void setController(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public Node selected() { return this.selNode; }
	
	void draw(PApplet p)
	{
		if (selNode != null)
		{
			selNode.setPosition(p.mouseX, p.mouseY);
		}
	}
	
	public void mousePressed(PApplet p)
	{
		float thresh = 10;
		
		// if something is selected and conflicts, forgo this
		// if the active box is not selected, do this
		for (Node temp : nodes)
		{
			float d = temp.EuclideanDistance(p.mouseX, p.mouseY);
			
			if (d < thresh)
			{
				if (selNode == null)
				{
					selNode = temp;
					p0 = temp;
					thresh = d; // why ?
				}
				if (p0 != null && p0 != temp)
				{
					Node p1 = temp;
					edges.add( new Edge(p0, p1) );
					p0 = null;
				}
			}
		}
	
		// if node is not selected, add node
		if (selNode == null)
		{
			nodes.add( new Node(p.mouseX, p.mouseY) );
		}
		
		// deselect; has to be after the add function or else it will deselect and add at the same time
//		else if (selNode != null)
//		{
//			selNode = null;
//		}
		
	}
	
	public void mouseReleased()
	{
		selNode = null;
	}
}

package usf.saav.howard.rewrite;

import java.util.ArrayList;
import processing.core.PApplet;

public class Controller {

	// because everything is pass by reference in Java
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	GraphSet GS;
	
	Node p0 = null;
	// movement variables
	Node selNode = null;
	Edge selEdge = null; // don't think I need this because pass by reference
	
	Controller()
	{
		this.nodes = new ArrayList<Node>();
		this.edges = new ArrayList<Edge>();
		this.GS = new GraphSet();
	}
	
	Controller (ArrayList<Node> nodes, ArrayList<Edge> edges, GraphSet GS)
	{
		this.nodes = nodes;
		this.edges = edges;
		this.GS = GS;
	}

	public void setController(ArrayList<Node> nodes, ArrayList<Edge> edges)
	{
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public Node selected() { return this.p0; }
	
	void draw(PApplet p)
	{
		if (selNode != null)
		{
			selNode.setPosition(p.mouseX, p.mouseY);
		}
		
		//if (p0 != null)
			//System.out.println(selNode + " " + p0.getX() + " " + p0.getY() );
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
					selNode = temp;
					thresh = d; // why ?
			}
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
	
	public void keyPressed(PApplet p)
	{
//		if ( p.key == 'c' ) 
//		{
//			p0 = null;
//		}
		
		// good for testing
		// keep here for now. Above clears the node selected, which should be used in ActiveBox
		if (p.key == 'c')
		{
			this.nodes.clear();
			this.edges.clear();
		}
	}

	public void mouseClicked(PApplet p) 
	{
		float thresh = 10;
		
		// if something is selected and conflicts, forgo this
		// if the active box is not selected, do this
		Node p1 = null;
		for (Node temp : nodes) {
			float d = temp.EuclideanDistance(p.mouseX, p.mouseY);
			
			if (d < thresh) {
				thresh = d;
				p1 = temp;
			}
		}
		
		if( p1 == null ) {
			nodes.add( new Node(p.mouseX, p.mouseY, nodes.size() + 1) );
		}
		else 
		{
			if( p0 == null ) {
				p0 = p1;
			}
			else if (p0 != p1){
				edges.add( new Edge(p0, p1) );
				p0 = null;
			}
		}
	}
}

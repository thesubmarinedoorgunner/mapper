package usf.saav.howard.rewrite;

import java.util.ArrayList;
import processing.core.PApplet;

public class Controller {

	/*
	// because everything is pass by reference in Java
	private ArrayList<Node> nodes;
	private ArrayList<Edge> edges;
	GraphSet GS;
	
	Node p0 = null;
	// movement variables
	Node selNode = null;
	Edge selEdge = null; // don't think I need this because pass by reference
	*/
	
	Model m;
	
	Controller(Model m)
	{
		//this.nodes = new ArrayList<Node>();
		//this.edges = new ArrayList<Edge>();
		//this.GS = new GraphSet();
		this.m = m;
	}
	
	/*
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
	*/
	
	//public Node selected() { return this.p0; }
	

	void draw(PApplet p)
	{
		if ( m.selNode != null /*&& !m.gs.edges.isEmpty()*/ ) { m.gs.DijkstraSet(m.selNode); }
		if ( m.selNode != null && p.mousePressed )
		{
			m.selNode.setPosition(p.mouseX, p.mouseY);
		}
		
		
		//if (p0 != null)
			//System.out.println(selNode + " " + p0.getX() + " " + p0.getY() );
	}
	
	public void mousePressed(PApplet p)
	{
		Node oldSel = m.selNode;
		
		m.selNode = null;
		float thresh = 10;
		
		// if something is selected and conflicts, forgo this
		// if the active box is not selected, do this
		for (Node temp : m.gs.nodes)
		{
			float d = temp.EuclideanDistance(p.mouseX, p.mouseY);
			
			if (d < thresh)
			{
					m.selNode = temp;
					thresh = d; // why ?
			}
		}
		
		if( m.selNode != null && oldSel != null && m.selNode != oldSel ) {
			m.gs.edges.add( new Edge(m.selNode, oldSel) );
		}
		
		
		// deselect; has to be after the add function or else it will deselect and add at the same time
//		else if (selNode != null)
//		{
//			selNode = null;
//		}
		
	}
	
	public void mouseReleased(PApplet p)
	{
		//m.selNode = null;
		if( m.selNode == null ) {
			m.gs.nodes.add( new Node(p.mouseX, p.mouseY, m.gs.nodes.size() + 1) );
		}
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
			m.gs.nodes.clear();
			m.gs.edges.clear();
			m.selNode = null;
		}
	}

	public void mouseClicked(PApplet p) 
	{
		mousePressed(p);
		mouseReleased(p);
		/*
		float thresh = 10;
		
		// if something is selected and conflicts, forgo this
		// if the active box is not selected, do this
		Node p1 = null;
		for (Node temp : m.gs.nodes) {
			float d = temp.EuclideanDistance(p.mouseX, p.mouseY);
			
			if (d < thresh) {
				thresh = d;
				p1 = temp;
			}
		}
		
		//if( m.selNode != null ) {
		//	m.selNode = null;
		//}
		//else 
		if( p1 == null ) {
			m.gs.nodes.add( new Node(p.mouseX, p.mouseY, m.gs.nodes.size() + 1) );
		}
		else 
		{
			if( m.p0 == null ) {
				m.p0 = p1;
			}
			else if (m.p0 != p1){
				m.gs.edges.add( new Edge(m.p0, p1) );
				m.p0 = null;
			}
		}
		*/
	}
}

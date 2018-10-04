package usf.saav.howard.rewrite;

import processing.core.PApplet;

public class Edge {
	
	private Node p0, p1;
	
	Edge() 
	{
		this.p0 = null;
		this.p1 = null;
	}
	Edge(Node p0, Node p1)
	{
		this.p0 = p0;
		this.p1 = p1;
	}
	
	protected void setEdge(Node p0, Node p1)
	{
		this.p0 = p0;
		this.p1 = p1;
	}
	
	protected void setp0(Node p0)
	{
		this.p0 = p0;
	}
	protected Node getp0()
	{
		return this.p0;
	}
	
	protected void setp1(Node p1)
	{
		this.p1 = p1;
	}
	protected Node getp1()
	{
		return this.p1;
	}
	
	protected void draw(PApplet p)
	{
		p.draw();
	}
	
	

}

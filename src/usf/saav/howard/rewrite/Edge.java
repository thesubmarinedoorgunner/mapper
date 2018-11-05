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
	
	public void setEdge(Node p0, Node p1)
	{
		this.p0 = p0;
		this.p1 = p1;
	}
	
	public void setp0(Node p0)
	{
		this.p0 = p0;
	}
	public Node getp0()
	{
		return this.p0;
	}
	
	public void setp1(Node p1)
	{
		this.p1 = p1;
	}
	public Node getp1()
	{
		return this.p1;
	}
	
	public float getEuclideanDistance()
	{
		float xSq = ( p1.getX() - p0.getX() ) * ( p1.getX() - p0.getX() );
		float ySq = ( p1.getY() - p0.getY() ) * ( p1.getY() - p0.getY() );
		float dist = (float)Math.sqrt( xSq + ySq );
		
		return dist;
	}
	
	public void draw(PApplet p)
	{
		p.stroke(200);
		p.line(p0.getX(), p0.getY(), p1.getX(), p1.getY() );
	}
	public void drawHeavy(PApplet p)
	{
		System.out.println("Drawing heavy");
		p.stroke(0);
		p.line(p0.getX(), p0.getY(), p1.getX(), p1.getY() );
	}

}

package usf.saav.howard.rewrite;

import processing.core.PApplet;
import processing.core.PVector;

public class Node {

	private PVector node;
	
	Node()
	{
		node = null;
	}
	Node(float x, float y)
	{
		this.node = new PVector (x, y);
	}
	
	public void setPVector(float x, float y)
	{
		this.node = new PVector(x, y);
	}
	public PVector getPVector()
	{
		return this.node;
	}
	
	public void setX(float x)
	{
		this.node.x = x;
	}
	public float getX()
	{
		return this.node.x;
	}
	
	public void setY(float y)
	{
		this.node.y = y;
	}
	public float getY()
	{
		return this.node.y;
	}
	
	public void draw(PApplet p)
	{
		p.ellipse(this.node.x, this.node.y, 5, 5);
	}
	
}

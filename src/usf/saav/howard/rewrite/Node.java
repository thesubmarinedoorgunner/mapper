package usf.saav.howard.rewrite;

import processing.core.PApplet;
import processing.core.PVector;

public class Node {

	private float x, y;
	private PVector node;
	
	Node()
	{
		this.x = -1;
		this.y = -1;
		node = null;
	}
	Node(float x, float y)
	{
		this.x = x;
		this.y = y;
		this.node = new PVector (x, y);
	}
	
	protected void setPVector(float x, float y)
	{
		this.node = new PVector(x, y);
		this.x = x;
		this.y = y;
	}
	protected PVector getPVector()
	{
		return this.node;
	}
	
	protected void setX(float x)
	{
		this.x = x;
		this.node = new PVector(x, this.y);
	}
	protected float getX()
	{
		return this.x;
	}
	
	protected void setY(float y)
	{
		this.y = y;
		this.node = new PVector(this.x, y);
	}
	protected float getY()
	{
		return this.y;
	}
	
	protected void draw(PApplet p)
	{
		p.ellipse(this.x, this.y, 5, 5);
	}
	
}

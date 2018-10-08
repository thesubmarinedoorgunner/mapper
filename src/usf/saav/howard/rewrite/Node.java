package usf.saav.howard.rewrite;

import processing.core.PApplet;
import processing.core.PVector;

public class Node {

	private PVector node;
	private int number;
	
	Node()
	{
		node = null;
	}
	Node(float x, float y, int number)
	{
		this.node = new PVector (x, y);
		this.number = number;
	}
	
	public void setPosition(float x, float y)
	{
		this.node.x = x;
		this.node.y = y;
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
	public void setNumber(int number)
	{
		this.number = number;
	}
	public int getNumber()
	{
		return this.number;
	}
	
	public float EuclideanDistance(float x, float y)
	{
		float dist = (float) Math.sqrt( (x - this.node.x)*(x - this.node.x) + (y - this.node.y)*(y - this.node.y) );
		return dist; 
	}
	
	public void draw(PApplet p)
	{
		p.stroke(0);
		p.fill(100);
		p.ellipse(this.node.x, this.node.y, 10, 10);
	}
	
}

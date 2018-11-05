package usf.saav.howard.rewrite;

import processing.core.PApplet;
import processing.core.PVector;
import java.util.ArrayList;

public class Node {

	private PVector node;
	private int number;
//	private float geodesic = -1;
	/*
	ArrayList<Node> nodes = new ArrayList<Node>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	*/
	
	// I don't think calculating Dijkstra's here is the best implementation
	//public Dijkstra dijkstrasAlgorithm = new Dijkstra();
	
	Node() { this.node = null; }

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
	public void setPVector(float x, float y) { this.node = new PVector(x, y); }
	public PVector getPVector() { return this.node; }
	
	public void setX(float x) { this.node.x = x; }
	public float getX() { return this.node.x; }

	public void setY(float y) { this.node.y = y; }
	public float getY() { return this.node.y; }

	public void setNumber(int number) { this.number = number; }
	public int getNumber() { return this.number; }

//	public float getGeodesic() {return this.geodesic;}
//	public void setGeodesic(float geodesic) {this.geodesic = geodesic;}

	public float EuclideanDistance(float x, float y)
	{
		float dist = (float) Math.sqrt( (x - this.node.x)*(x - this.node.x) + (y - this.node.y)*(y - this.node.y) );
		return dist; 
	}
	
    public float EuclideanDistance(Node another)
    {
        float dist = (float)Math.sqrt( (another.node.x - this.node.x)*(another.node.x - this.node.x) + (another.node.y - this.node.y)*(another.node.y - this.node.y) );
        return dist;
    }
	public void draw(PApplet p)
	{
		p.stroke(0);
		p.fill(100);
		p.ellipse(this.node.x, this.node.y, 10, 10);
	}
	
}

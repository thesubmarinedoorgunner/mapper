package usf.saav.howard.rewrite;

import java.util.ArrayList;

import processing.core.PApplet;

public class ActiveBox extends FrameLite{

	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	
	Node p0 = null;
	float geodesic = -1; 
	
	public ActiveBox() {
		
		this.h0 = this.v0 = this.w = this.h = 1;
		// or -1 ?
	}
	
	public ActiveBox(int h0, int v0, int w, int h)
	{
		this.h0 = h0;
		this.v0 = v0;
		this.w = w;
		this.h = h;
	}
	
	// have setter for active node
	// node should automagically set itself back to node b/c pass by ref ?
	public void setSelNode(Node p0) {this.p0 = p0;}
	public void setGeodesic(float geodesic) {this.geodesic = geodesic;}

	// have setter for geodesic
	
	// abstract class already has a setPosition function
	
	public void draw(PApplet p)
	{
		p.fill(255);
		p.stroke(0);
		p.rect(this.h0, this.v0, this.w, this.h, 7);
		
		p.textSize(12);
		p.fill(50);
		if (p0 == null)
		{	
			p.text("No node selected", ( this.h0 + (this.w / 4) ), (this.v0 + 20) );
			// textRHC("No node selected", ( this.h0 + (this.w / 2) ), (this.v0 + 10), p );
		}
		else
		{
			p.text("Node selected: " + p0.getNumber(), ( this.h0 + (this.w / 4) ), (this.v0 + 20) );
		}
	}
	
	// already has a mouseInside function too

}

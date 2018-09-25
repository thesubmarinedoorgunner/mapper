package usf.saav.howard;

import processing.core.PApplet;

public class ActiveBox extends Frame {

	
	ActiveBox(int u0, int v0, int w, int h)
	{
		this.u0 = u0;
		this.v0 = v0;
		this.w = w;
		this.h = h;
	}
	@Override
	void draw(PApplet p) {
		// TODO Auto-generated method stub
		
		p.background(255);
		p.stroke(0);
		p.strokeWeight(3);
		p.fill(255);
		
		p.rect(u0, v0, w, h, 7);
		
	}
	
	// gets the information from node to display
	void nodeInformation()
	{
		// null param only on objects
	}
	
	// clears the display once node is de-selected
	void nodeClear()
	{
		
	}
	
}

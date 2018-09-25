package usf.saav.howard;

import processing.core.PApplet;

public class staticFunctions {
	
	// I don't think I can have variables in here for static function use
	
	staticFunctions()
	{
		
	}
	
	boolean clickedOn(float x, float y, Node node, PApplet p)
	{
		if ( Math.abs(node.posX - p.mouseX) < 2 && Math.abs(node.posY - p.mouseY) < 2)
		{
			return true;
		}
		
		return false;
	}
	
	public static void buildTopDisplay(PApplet p)
	{
		Node selected = null;
		
		p.background(255);
		p.stroke(0);
		p.strokeWeight(3);
		p.fill(255);
		p.rect(p.width - 150, 0, 150, 150, 7 );
		
		// default is none selected
		if (selected != null)
		{
			// display the node at the corner along with
			// but then the question about de-selecting
			// if selected again, then turn node back to null 
		}
	}
	
	public static float geodesic(Node node1, Node node2)
	{
		// how to do this w/o pointers ? 
		
		return 1.1f;
	}

}

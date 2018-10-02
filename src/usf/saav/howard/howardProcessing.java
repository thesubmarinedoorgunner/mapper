package usf.saav.howard;

import java.io.File;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.JSONObject;

public class howardProcessing extends PApplet
{
	
	public howardProcessing() {
	// can put stuff here, but don't
		println( "constructor: " + width );
	}
	
	public void settings()
	{
		size(1200, 600, P3D);
		println( "settings: " + width );
	}
	
	// setup and draw like normal Processing
	public void setup()
	{
		ortho(); 
		frameRate(30);
		//selectInput("Select a file to process", "fileSelected");
		
		println( "setup: " + width );
		
		box1 = new ActiveBox(width - 150, 0, 150, 150);
		
	}
	
	public void fileSelected(File selection)
	{
		if (selection == null)
		{
			System.out.println("Windows was closed or user hit cancel");
			exit();
		}
		else
		{
			System.out.println("User selected " + selection.getAbsolutePath() );
		}
	}
	
	// if clicked, create a new node and add
	
	// after parsing
//	NodeSet NS = new NodeSet();
	ArrayList<Node> nodes = new ArrayList<Node>();
	ActiveBox box1 = null;
	
	public void draw()
	{
		background(255);

		box1.draw(this);

		// why ?
//		ActiveBox box2 = new ActiveBox(width - 150, 0, 150, 150);
//		box2.draw(this);
		
		for (Node temp : nodes)
		{
			temp.draw(this);
		}
		
		
		if( sel != null ) {
			sel.posX = mouseX;
			sel.posY = mouseY;
		}
		// the node works. Leave for testing 
//		Node tempNode = new Node(width/2, height/2);
//		tempNode.draw(this);
		
		
	}

	Node sel = null;

	public void mousePressed() 
	{
		if ( !box1.mouseInside(mouseX, mouseY, this) )
		{
			// holy for loop runtime increase if I check every single node for x and y position
			
			float thres = 10;
			for( Node n : nodes ) {
				float d = n.EuclideanDistance(mouseX, mouseY);
				if( d < thres ) {
					sel = n;
					thres = d;
				}
			}
			if( sel == null ) {
				nodes.add(new Node(mouseX, mouseY) );
			}
		}
	}
	
	public void mouseReleased() {
		sel = null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args) {
		// don't touch
		try {
		PApplet.main( new String[] {"usf.saav.howard.howardProcessing"} );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
}



package usf.saav.howard;

import java.io.File;

import processing.core.PApplet;
import processing.data.JSONObject;

public class howardProcessing extends PApplet
{
	
	public howardProcessing() {
	// can put stuff here, but don't
	}
	
	public void settings()
	{
		size(1200, 600, P3D);
	}
	
	// setup and draw like normal Processing
	public void setup()
	{
		ortho(); 
		frameRate(30);
		selectInput("Select a file to process", "fileSelected");
	}
	
	void fileSelected(File selection)
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
	public void draw()
	{
		background(255);
		//staticFunctions.buildTopDisplay(this);
		ActiveBox box1 = new ActiveBox(width - 150, 0, 150, 150);
		
		box1.draw(this);
		
		Node tempNode = new Node(width/2, height/2);
		tempNode.draw(this);
		
		
	}
	
	public void mousePressed() {}
	
	public void mouseReleased() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String [] args) {
		// don't touch
		try {
		PApplet.main( new String[] {"usf.saav.howard.howardProcessing"} );
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	
}



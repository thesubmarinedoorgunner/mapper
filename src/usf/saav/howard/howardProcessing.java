package usf.saav.howard;

import processing.core.PApplet;

public class howardProcessing extends PApplet
{
	
	public howardProcessing() {
	// can put stuff here, but don't
	}
	
	public void settings()
	{
		size(1600, 900, P3D);
	}
	
	// setup and draw like normal Processing
	public void setup()
	{
		ortho(); 
		frameRate(30);
	}
	
	public void draw()
	{
		background(255);
		
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



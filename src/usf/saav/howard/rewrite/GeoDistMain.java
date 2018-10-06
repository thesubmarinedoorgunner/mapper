
package usf.saav.howard.rewrite;

import java.util.ArrayList;

import processing.core.PApplet;

public class GeoDistMain extends PApplet {


	public GeoDistMain() {
		// can put stuff in here, but do not
		// just because you can, does not mean you should
	}

	public void settings()
	{
		size(1200, 600, P3D);
	}
	
	public void setup()
	{
		ortho();
		frameRate(30);
	}
	
	public void draw()
	{
		background(255);
		
		test1.draw(this);
		test2.draw(this);
//		if (test2.selected() != null)
//		{
//			test2.selected().setPosition(mouseX, mouseY);
//		}
	}
	
	ArrayList<Node> nodes = new ArrayList<Node>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	GraphSet test1 = new GraphSet(nodes, edges);
	Controller test2 = new Controller(nodes, edges);
	
	public void mousePressed()
	{
		test2.mousePressed(this);
	}
	
	public void mouseReleased()
	{
		test2.mouseReleased();
	}
	
	
	public static void main(String[] args) {
		
		try
		{
			PApplet.main( new String[] {"usf.saav.howard.rewrite.GeoDistMain"} );
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}

	}

}

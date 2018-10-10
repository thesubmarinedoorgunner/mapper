
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
		
		// pass GS into controller and active box as a class
		test1.draw(this);
		test2.draw(this);
		
		test3.setPosition(width - 150, 0, 150, 150);
		test3.setSelNode( test2.selected() );
		test3.draw(this);
//		if (test2.selected() != null)
//		{
//			test2.selected().setPosition(mouseX, mouseY);
//		}
	}
	
	ArrayList<Node> nodes = new ArrayList<Node>();
	ArrayList<Edge> edges = new ArrayList<Edge>();
	
	GraphSet test1 = new GraphSet(nodes, edges);
	Controller test2 = new Controller(nodes, edges);
	ActiveBox test3 = new ActiveBox();
	
	public void mousePressed()
	{
		test2.mousePressed(this);
	}
	
	public void mouseReleased()
	{
		test2.mouseReleased();
	}
	
	public void keyPressed()
	{
		test2.keyPressed(this);
	}
	
	public void mouseClicked() {
		
		test2.mouseClicked(this);
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

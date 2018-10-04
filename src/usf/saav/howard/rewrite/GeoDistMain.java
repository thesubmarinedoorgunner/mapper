/**
 * 
 */
package usf.saav.howard.rewrite;

import processing.core.PApplet;

/**
 * @author howardcheung
 *
 */

public class GeoDistMain extends PApplet {

	/**
	 * 
	 */
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

package usf.saav.howard.rewrite;

import processing.core.PApplet;

public abstract class Frame extends FrameLite {

//	int h0 = super.h0;
	
	@Override
	public abstract void draw(PApplet p);
	

	
// Why does this not work and the above does ?
//	super.h0 = 5;

}

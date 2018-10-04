package usf.saav.howard.rewrite;

import processing.core.PApplet;

public abstract class Frame extends FrameLite {

//	int h0 = super.h0;
	
	@Override
	public abstract void draw(PApplet p);
	
	public boolean mouseInside(int x, int y, PApplet p)
	{
		int clickBuffer = 5;
		
		return ( (this.h0 - clickBuffer < p.mouseX)&& (this.h0 + w + clickBuffer) > p.mouseX && (this.v0 - clickBuffer) < p.mouseY && (v0 + h +clickBuffer) > p.mouseY );
	}
	
// Why does this not work and the above does ?
//	super.h0 = 5;

}

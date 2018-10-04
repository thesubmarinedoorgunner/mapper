package usf.saav.howard.rewrite;

import processing.core.PApplet;

// taken from the brilliant ideas of Dr. Rosen

public abstract class FrameLite {
	
	protected int h0, v0, w, h;
	
	FrameLite() {}
	
	FrameLite(int h0, int v0, int w, int h)
	{
		this.h0 = h0;
		this.v0 = v0;
		this.w = w;
		this.h= h;
	}
	
	protected void setPosition(int h0, int v0, int w, int h)
	{
		this.h0 = h0;
		this.v0 = v0;
		this.w = w;
		this.h = h;
	}
	
	protected abstract void draw(PApplet p);
	
	protected void mousePressed() {}
	protected void mouseReleased() {}
	
	

}

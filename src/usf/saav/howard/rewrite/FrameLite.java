package usf.saav.howard.rewrite;

import processing.core.PApplet;

// taken from the brilliant ideas of Dr. Rosen

public abstract class FrameLite {
	
	public int h0, v0, w, h;
	
	FrameLite() {}
	
	FrameLite(int h0, int v0, int w, int h)
	{
		this.h0 = h0;
		this.v0 = v0;
		this.w = w;
		this.h= h;
	}
	
	public void setPosition(int h0, int v0, int w, int h)
	{
		this.h0 = h0;
		this.v0 = v0;
		this.w = w;
		this.h = h;
	}
	
	public abstract void draw(PApplet p);
	
	public void mousePressed() {}
	public void mouseReleased() {}
	
	

}

package usf.saav.howard.rewrite;

import processing.core.PApplet;

// taken from the brilliant ideas of Dr. Rosen

public abstract class FrameLite {
	
	public int h0, v0, w, h;
	
	// Why do I pass an instance of PApplet when I can just create one ?
	// Because pass by reference ?
	// PApplet applet;
	
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
	
	public boolean mouseInside(int x, int y, PApplet p)
	{
		int clickBuffer = 5;
		
		return ( (this.h0 - clickBuffer < p.mouseX)&& (this.h0 + w + clickBuffer) > p.mouseX && (this.v0 - clickBuffer) < p.mouseY && (v0 + h +clickBuffer) > p.mouseY );
	}

	// thanks Dr. Rosen
	
//	void textRHC( String s, float x, float y, PApplet p )
//	{
//		// wow formatting is awful	
//		 p.pushMatrix();
//		 p.translate(x,y);
//		 p.scale(1,-1,1);
//		 p.text( s, 0, 0 );
//		 p.popMatrix(); 
//	}
}

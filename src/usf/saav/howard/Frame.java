package usf.saav.howard;

// taken from the brilliant ideas of Dr. Rosen
import processing.core.PApplet;

public abstract class Frame 
{
	// anything else I need to add ?
	int u0, v0, w, h;
	
	void setPosition(int u0, int v0, int w, int h)
	{
		this.u0 = u0;
		this.v0 = v0;
		this.w = w;
		this.h= h;
	}
	
	abstract void draw(PApplet p);
	
	void mousePressed() {}
	
	void mouseReleased() {}
	
	boolean mouseInside(int x, int y, PApplet p)
	{
		int clickBuffer = 5;
		
		return ( (this.u0 - clickBuffer < p.mouseX) && (this.u0 + w + clickBuffer) > p.mouseX && (this.v0 - clickBuffer) < p.mouseY && (v0 + h +clickBuffer) > p.mouseY );
		
	}

}

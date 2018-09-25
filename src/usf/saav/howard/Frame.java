package usf.saav.howard;

// taken from the brilliant ideas of Dr. Rosen
import processing.core.PApplet;
import java.util.*;

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
	
	

}

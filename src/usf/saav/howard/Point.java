package usf.saav.howard;

import processing.core.PApplet;
import processing.core.PVector;

//import processing.core.PApplet;

public class Point {
	
	float x, y;
	// would be passed the size of the Pointers array list
	int insertOrder;
	PVector pnt;
	
	
	// range for clicked on is +/- 5
	int range = 5;
	
	Point(float x, float y, int insertOrder)
	{
		this.x = x;
		this.y = y;
		this.insertOrder = insertOrder;
	}
	// pass it the PApplet to draw 
	void draw(PApplet p)
	{
		p.ellipse(x, y, 5, 5);
	}
}

package usf.saav.howard;

import processing.core.PApplet;
import processing.data.JSONObject;

public class Node extends Frame{
	
	// class members
	String id;
	int group;
	// from the bottom
	int posX, posY;
	float geodesic;
	
	// constructor for node created in the sketch
	Node(int posX, int posY)
	{
		this.posX = posX;
		this.posY = posY;
	}
	// constructor for node created from JSON
	Node(JSONObject object)
	{
		this.id = object.getString("id");
		this.group = object.getInt("group");
		
		// this.posX = posX;
		// this.posY = posY;
		// need to add position
	}
	
	void draw(PApplet p)
	{
		p.stroke(0);
		p.strokeWeight(3);
		p.fill(255);
		
		p.ellipse(this.posX, this.posY, 25, 25);
		// text of the number;
	}
	/*
	 * Experimenting with stuff
	 */
	
	
	float getGeodesic()
	{
		return this.geodesic;
	}
	void setGeodesic(float geodesic)
	{
		this.geodesic = geodesic;
	}
	
	
	// float half = height / 2;

	
	/*
	 * Done experiementing
	 */
	
	
	// returns to write back to file
	public JSONObject returnFunction()
	{
		JSONObject temp = new JSONObject();
		temp.setString("id", id);
		temp.setInt("group", group);
		
		return temp;
	}

}

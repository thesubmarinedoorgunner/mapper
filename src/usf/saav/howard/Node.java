package usf.saav.howard;

import processing.data.JSONObject;

public class Node {
	
	// class members
	String id;
	int group;
	
	// constructor
	Node(JSONObject object)
	{
		this.id = object.getString("id");
		this.group = object.getInt("group");
		
		// this.posX = posX;
		// this.posY = posY;
		// need to add position
	}
	
	
	/*
	 * Experimenting with stuff
	 */
	
	float posX, posY; 
	float geodesic;
	
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

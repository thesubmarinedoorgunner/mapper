package usf.saav.howard;

import java.util.ArrayList;
import processing.core.*;

import processing.data.JSONArray;

public class NodeSet {

	ArrayList<Node> NS = new ArrayList<Node>();
	
	NodeSet(JSONArray array)
	{
		for(int i = 0; i < array.size(); i++)
		{
			NS.add(new Node( array.getJSONObject(i)) );
		}
	}
	
	void draw(PApplet p)
	{
		for (Node temp : NS)
		{
			p.ellipse(temp.posX, temp.posY, 5, 5);
		}
	}
	
	
	
	// getters and setters
	ArrayList<Node> getNS()
	{
		return this.NS;
	}
	void setNS(ArrayList<Node> NS)
	{
		this.NS = NS;
	}
	
	
	
	
	
	
	
	
	// writes to a JSON file
	// I see why you named it 'toJSON' now
	public JSONArray returnFunction()
	{
		JSONArray temp = new JSONArray();
		for(int i = 0; i < NS.size(); i++)
		{
			temp.append(NS.get(i).returnFunction() );
		}
		
		return temp;
	}
	
}

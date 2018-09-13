package usf.saav.howard;

import java.util.ArrayList;

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

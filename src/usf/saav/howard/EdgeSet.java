package usf.saav.howard;

import java.util.ArrayList;
import processing.data.JSONArray;

// Lord Jesus this is a bit confusing. I'm glad I have a reference

public class EdgeSet {

	ArrayList <Edge> ES = new ArrayList <Edge>();
	
	EdgeSet(JSONArray array)
	{
//		for (int i = 0; i < array.size(); i++)
//		{
//			ES.add(new Edge(array.getJSONObject(i) ) );
//		}
	}
	
	ArrayList <Edge> getES()
	{
		return ES;
	}
	
	void setES(ArrayList <Edge> ES)
	{
		this.ES = ES;
	}
	
	// write out ? Or in Edge class ?
	
}

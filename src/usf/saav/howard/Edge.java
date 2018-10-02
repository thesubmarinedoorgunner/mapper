package usf.saav.howard;

import processing.core.PApplet;
import processing.data.JSONObject;

public class Edge {
	
	Node node1, node2;
	
	// for adding inside of the window
	Edge(Node node1, Node node2)
	{
		this.node1 = node1;
		this.node2 = node2;
	}
	
//	Edge(JSONObject edge)
//	{
//		this.node1 = new Node(edge.get();
//		this.node2 = edge.
//	}
	
	void draw(PApplet p)
	{
		p.line(node1.posX, node1.posY, node2.posX, node2.posY);
	}

	// write back
}

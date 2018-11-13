package usf.saav.howard.rewrite;

import java.util.ArrayList;
import java.util.HashMap;

public class Prim {

	public ArrayList<Node> nodes;
	public ArrayList<Edge> edges;
	public ArrayList<Edge> path = new ArrayList<Edge>();
	public ArrayList<Node> queue;
	
	private Node base;
	
	public HashMap<Node, PrimContainer> container;
	
	public Prim() {
		// TODO Auto-generated constructor stub
	}

	
	public class PrimContainer
	{
		PrimContainer()
		{
			
		}
	}
}

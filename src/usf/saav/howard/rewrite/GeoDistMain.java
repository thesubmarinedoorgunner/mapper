
package usf.saav.howard.rewrite;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

public class GeoDistMain extends PApplet {


	public GeoDistMain() {
		// can put stuff in here, but do not
		// just because you can, does not mean you should
	}

	public void settings()
	{
		size(1200, 600, P3D);
	}
	
	public void setup()
	{
		ortho();
		frameRate(30);
		
		// what kind of black magic did I do to make this work ?
		selectInput("Select a file to process: ", "fileSelected");
		
	}
	
	public void draw()
	{
		background(255);
		
		// pass GS into controller and active box as a class
		//test1.draw(this);
		m.gs.draw(this);
		controller.draw(this);
		
		activeBox.setPosition(width - 150, 0, 150, 150);
		activeBox.setSelNode( m.selNode );
		activeBox.draw(this);
//		if (test2.selected() != null)
//		{
//			test2.selected().setPosition(mouseX, mouseY);
//		}
		
	}
	
	//ArrayList<Node> nodes = new ArrayList<Node>();
	//ArrayList<Edge> edges = new ArrayList<Edge>();
	
	//GraphSet test1 = new GraphSet(nodes, edges);
	//Controller test2 = new Controller(nodes, edges, test1);
	Model m = new Model();
	Controller controller = new Controller( m );
	ActiveBox activeBox = new ActiveBox();
	
	public void mousePressed()
	{
		controller.mousePressed(this);
	}
	
	public void mouseReleased()
	{
		controller.mouseReleased(this);
	}
	
	public void keyPressed()
	{
		controller.keyPressed(this);
		
		if (key == 's')
		{
			fileSave();
			System.out.println("Supposed to have saved");
		}
	}
	
	public void mouseClicked() {
		
		controller.mouseClicked(this);
	}
	
	public void fileSelected(File selection)
	{
//		try
//		{
			if (selection == null)
			{
				System.out.println("Windows was closed or the user hit cancel ");
				return;
			}
			else
			{
				System.out.println("User selected: " + selection.getAbsolutePath() );
				
				// where did the imports go ?
				JSONObject file;
				JSONArray nodes, edges;
				
				file = loadJSONObject(selection.getAbsolutePath() );
				nodes = file.getJSONArray("nodes");
				edges = file.getJSONArray("edges");
				
				for (int i = 0; i < nodes.size(); i++)
				{
					JSONObject node = nodes.getJSONObject(i);
					float x = node.getFloat("x");
					float y = node.getFloat("y");
					int num = node.getInt("number");
					
					((List<Node>) nodes).add( new Node(x, y, num) );
				}
				
				for (int i = 0; i < edges.size(); i++)
				{
					JSONObject edge = edges.getJSONObject(i);
					int source = edge.getInt("source");
					int target = edge.getInt("target");
					
					((List<Edge>) edges).add( new Edge( ((List<Node>)nodes).get(source - 1), ((List<Node>)nodes).get(target - 1) ));
				}
			}
		//}
//		catch(Exception e)
//		{
//			
//		}

	}
	
	// only called when user presses 's'
	public void fileSave()
	{
		JSONObject json = new JSONObject();
		JSONArray nodesJS = new JSONArray();
		JSONArray edgesJS = new JSONArray();
		
		for (int i = 0; i < m.gs.nodes.size(); i++)
		{
			float x = m.gs.nodes.get(i).getX();
			float y = m.gs.nodes.get(i).getY();
			int num = m.gs.nodes.get(i).getNumber();
			
			JSONObject temp = new JSONObject();
			temp.setFloat("x", x);
			temp.setFloat("y", y);
			temp.setInt("number", num);
			nodesJS.setJSONObject(i,temp);
		}
		json.setJSONArray("nodes", nodesJS);
				
		for (int i = 0; i < m.gs.edges.size(); i++)
		{
			int source = m.gs.edges.get(i).getp0().getNumber();
			int target = m.gs.edges.get(i).getp1().getNumber();
			
			JSONObject temp = new JSONObject();
			temp.setInt("source", source);
			temp.setInt("target", target);
			edgesJS.setJSONObject(i, temp);
		}
		json.setJSONArray("edges",edgesJS);
		
		// do I use absolute path + this path ?
		saveJSONObject(json, "data/data.json");
	}
	public static void main(String[] args) {
		
		try
		{
			PApplet.main( new String[] {"usf.saav.howard.rewrite.GeoDistMain"} );
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}

	}

}

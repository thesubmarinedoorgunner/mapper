package usf.saav.howard;

import processing.core.PApplet;
import java.util.*;
import java.io.File;
import java.lang.*;



public class fileSelection {
	
	PApplet p;
	fileSelection(PApplet p)
	{
		this.p = p;
	}

	public static void fileSelect(File selection)
	{
		if (selection == null)
		{
			System.out.println("Window was closed or the user hit cancel.");
			System.exit(0);
		}
		
	}
}

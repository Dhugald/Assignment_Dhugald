package pAssignment1Dhugald;


import java.util.ArrayList;

public class CSGOApp {
	
	public static void main(String[] args)
	{
		ArrayList<Games> matches = new ArrayList<Games>();
		BaseReader.load(matches);
		
		
		CSGOGUI gui = new CSGOGUI(matches);
		gui.setVisible(true);
		
	}
	
	
}

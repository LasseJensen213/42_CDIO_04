package boundary;

import desktop_resources.GUI;

public class LandOnFieldBoundary {

	public static boolean buyChoice(){
		String[] options = {"Ja", "Nej"};
		return GUI.getUserButtonPressed("Vil du købe?", options).equals(options[0]);
	}
	
	public static void moveToJail(String name, int pos){
		GUI.removeCar(pos, name);
		GUI.setCar(10, name);
	}
	
	
	
}

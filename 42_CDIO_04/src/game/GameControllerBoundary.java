package game;

import desktop_resources.GUI;

public class GameControllerBoundary {


	
	public void showWinnerMsg(String name)
	{
		GUI.showMessage(String.format("Vinderen er: %s", name));
	}

}

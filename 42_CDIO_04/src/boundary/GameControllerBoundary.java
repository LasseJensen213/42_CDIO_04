package boundary;

import desktop_resources.GUI;
import stringbanks.Stringbanks_GameController;

public class GameControllerBoundary {


	
	public void showWinnerMsg(String name)
	{
		GUI.showMessage(String.format(Stringbanks_GameController.get(0), name));
	}
	
	public void announceTurn(String name)
	{
		GUI.showMessage(String.format(Stringbanks_GameController.get(1), name));
	}

}

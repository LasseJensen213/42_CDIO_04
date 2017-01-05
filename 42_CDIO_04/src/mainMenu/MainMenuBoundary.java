package mainMenu;

import desktop_resources.GUI;
import stringbanks.Stringbanks_MainMenu;

public class MainMenuBoundary {

	public String MainMenuDropDownMenu()
	{
		String[] options = {Stringbanks_MainMenu.getString(1),
							Stringbanks_MainMenu.getString(2),
							Stringbanks_MainMenu.getString(4)};
		
		return GUI.getUserSelection(Stringbanks_MainMenu.getString(0), options );
	}
	
	public void gameRules()
	{
		GUI.showMessage(Stringbanks_MainMenu.getString(3));
	}
	
	public boolean confirmInput()
	{
		return GUI.getUserLeftButtonPressed(Stringbanks_MainMenu.getString(5), 
											Stringbanks_MainMenu.getString(6), 
											Stringbanks_MainMenu.getString(7));
	}
	
	public void close()
	{
		GUI.close();
	}

}

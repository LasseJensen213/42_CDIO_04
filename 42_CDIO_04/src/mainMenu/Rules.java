package mainMenu;

import java.io.IOException;

public class Rules {

<<<<<<< HEAD
	private String fileName = System.getProperty("user.dir")+"/Dokumentation/Regler.txt";
=======
	private final String fileName = "resources/rules/Regler.txt";
>>>>>>> branch 'develop' of https://github.com/LasseJensen213/42_CDIO_04

	public void open()
	{
		ProcessBuilder pb = new ProcessBuilder("Notepad.exe", fileName);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

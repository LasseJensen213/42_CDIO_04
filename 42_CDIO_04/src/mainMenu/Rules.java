package mainMenu;

import java.io.IOException;

public class Rules {

	private String fileName = "Regler.txt";

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

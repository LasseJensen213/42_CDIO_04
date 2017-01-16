package mainMenu;

import java.io.IOException;

public class Rules {

	private String fileName;


	public Rules()
	{
		String path = System.getProperty("user.dir")+"\\resources\\rules\\Regler.txt";
		fileName = path;
	}
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

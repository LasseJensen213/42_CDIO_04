package board;

import board.Board;
import desktop_resources.GUI;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
		board.generateBoard();
		GUI.showMessage("asdf");
		GUI.getUserSelection("Vil De købe feltet", "yes","no");
		GUI.getUserButtonPressed("Vil de købe feltet", "yes","no");
		
	}

}

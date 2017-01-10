package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import board.Board;
import board.FieldGenerator;
import desktop_fields.Field;
import desktop_resources.GUI;

public class BoardTest {
	FieldGenerator f;
	Board b;
	@Before
	public void setUp() throws Exception {
		Board b = new Board();
		FieldGenerator f = new FieldGenerator();
	}
	
	@After
	public void tearDown() throws Exception {
		Board b = null;
		FieldGenerator f = null;
	}

	@Test
	public void generateBoardtest() {
		b.generateBoard();
		
		Field[] fields = b.getFields();
		for(int i = 0;i<fields.length;i++) {
			f.getBgColors(i);

		}
		
		
		
	}

}

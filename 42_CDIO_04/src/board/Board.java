package board;

import java.awt.Color;

import desktop_fields.Field;

public class Board {


	public void generateBoard() {
		Field[] fields = new Field[40];
		//start,territory,chance,territory,
		
		Color bgColor = FieldGenerator.getBgColors(i);
		Color fgColor = FieldGenerator.getFgColors(i);
		fields[i]= new Street.Builder().setTitle(title).setDescription(subtext).setSubText(descr).
				setBgColor(bgColor).setFgColor(fgColor).setRent("").build();


	}

}
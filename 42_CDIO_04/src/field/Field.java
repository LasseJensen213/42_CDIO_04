package field;

import java.awt.Image;

public abstract class Field {
	
	private String desc;
	private String subtext;
	private String title;
	private Image image;
	private int fieldPosition;
	
	public Field(String desc, String subtext, String title, Image i, int pos) {
		this.desc = desc;
		this.subtext = subtext;
		this.title = title;
		this.image = i;
		this.fieldPosition = pos;
		
	}
	
	
	
}
		
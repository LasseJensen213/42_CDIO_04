package field;

import java.awt.Image;

public class Tax extends Field{
	
	private int tax;
	private int percentange;
	
	public Tax(String desc, String subtext, String title, int pos, int tax, int percentage) {
		super(desc,subtext,title,pos);
		this.tax = tax;
		this.percentange = percentage;
			
	}
	
	
}

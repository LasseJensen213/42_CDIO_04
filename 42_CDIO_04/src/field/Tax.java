package field;

import java.awt.Image;

public class Tax extends Field{
	
	private int tax;
	private int percentange;
	
	public Tax(String desc, String subtext, String title, Image i, int pos, int tax, int percentage) {
		super(desc,subtext,title,i,pos);
		this.tax = tax;
		this.percentange = percentage;
			
	}
	
	
}

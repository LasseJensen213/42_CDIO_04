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

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getPercentange() {
		return percentange;
	}

	public void setPercentange(int percentange) {
		this.percentange = percentange;
	}

	@Override
	public String toString() {
		return "Tax [tax=" + tax + ", percentange=" + percentange + ", getDesc()=" + getDesc() + ", getSubtext()="
				+ getSubtext() + ", getTitle()=" + getTitle() + ", getFieldPosition()=" + getFieldPosition()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}

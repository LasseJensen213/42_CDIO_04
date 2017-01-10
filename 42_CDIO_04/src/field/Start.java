package field;

public class Start extends Field{

	public Start(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
	}

	@Override
	public String toString() {
		return "Start [getDesc()=" + getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle()
				+ ", getFieldPosition()=" + getFieldPosition() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}	
	
	
	
	
	
	
}

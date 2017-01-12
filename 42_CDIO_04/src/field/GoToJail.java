package field;

public class GoToJail extends Field {
	public GoToJail(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
	}

	@Override
	public String toString() {
		return "GoToJail [getDesc()=" + getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle()
				+ ", getFieldPosition()=" + getFieldPosition() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}
	
	
	
}

package field;

public class Jail extends Field{

	public Jail(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
	}

	@Override
	public String toString() {
		return "Jail [getDesc()=" + getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle()
				+ ", getFieldPosition()=" + getFieldPosition() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + "]";
	}	

}

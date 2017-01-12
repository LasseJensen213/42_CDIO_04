package field;

public class Chance extends Field{
	public Chance(String desc, String subtext, String title, int pos) {
		super(desc,subtext,title,pos);
	}

	@Override
	public String toString() {
		return "Chance [getDesc()=" + getDesc() + ", getSubtext()=" + getSubtext() + ", getTitle()=" + getTitle()
				+ ", getFieldPosition()=" + getFieldPosition() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}	




}

package field;

public abstract class Field {
	
	private String desc;
	private String subtext;
	private String title;
	private int fieldPosition;
	
	public Field(String desc, String subtext, String title, int pos) {
		this.desc = desc;
		this.subtext = subtext;
		this.title = title;
		this.fieldPosition = pos;
		
	}

	public String getDesc() {
		return desc;
	}

	public String getSubtext() {
		return subtext;
	}

	public String getTitle() {
		return title;
	}

	public int getFieldPosition() {
		return fieldPosition;
	}

	@Override
	public String toString() {
		return "Field [desc=" + desc + ", subtext=" + subtext + ", title=" + title + ", fieldPosition=" + fieldPosition
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
		
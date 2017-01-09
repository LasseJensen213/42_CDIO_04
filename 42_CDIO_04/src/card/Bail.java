package card;

public class Bail extends Card {
	private boolean inUse;
	public Bail(String description) {
		super(description);
		setInUse(false);
	}
	public boolean isInUse() {
		return inUse;
	}
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

}

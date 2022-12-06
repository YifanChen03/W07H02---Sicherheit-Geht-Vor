package pgdp.security;

public abstract class SignalPost {

	/**
	 * Diese Klasse ist nur da, damit keine Buildfails entstehen. Allerdings ist sie
	 * bei Weitem noch nicht vollständig.
	 * 
	 */

	private int postNumber;
	private String depiction;
	private int level;

	public SignalPost(int postNumber) {
		this.postNumber = postNumber;
		depiction = "";
		level = 0;
	}

	public abstract boolean up(String type);
	public abstract boolean down(String type);

	public String toString() {
		String output = "Signal Post " + postNumber + ": " + level + " " + depiction;
		return output;
	}

	//Getter und Setter#

	public String getDepiction() {
		return depiction;
	}

	public void setDepiction(String depiction) {
		this.depiction = depiction;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPostNumber() {
		return postNumber;
	}

	public void setPostNumber(int postNumber) {
		this.postNumber = postNumber;
	}
}

package object;

public class VirusTransmission extends VirusAttribute{
	private int level;
	public VirusTransmission(String att_name, int level, String description, int cost) {
		super(att_name, description, cost);
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}

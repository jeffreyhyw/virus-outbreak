package object;

public class VirusAbility extends VirusAttribute{
	private int level;
	public VirusAbility(String att_name, int level, String description, int cost) {
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

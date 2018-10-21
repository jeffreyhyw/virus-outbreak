package object;

public class VirusAttribute {
	private String att_name;
	private int level;
	private String description;
	public VirusAttribute(String att_name, int level, String description) {
		this.att_name = att_name;
		this.level = level;
		this.description = description;
	}
	public String getAtt_name() {
		return att_name;
	}
	public void setAtt_name(String att_name) {
		this.att_name = att_name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}

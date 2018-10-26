package object;

public class VirusAttribute {
	private String att_name;
	private String description;
	private int cost;
	public VirusAttribute(String att_name, String description, int cost) {
		this.att_name = att_name;
		this.description = description;
		this.cost = cost;
	}
	public String getAtt_name() {
		return att_name;
	}
	public void setAtt_name(String att_name) {
		this.att_name = att_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}

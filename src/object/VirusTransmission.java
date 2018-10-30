package object;

public class VirusTransmission extends VirusAttribute{
	private int level;
	private String method;
	public VirusTransmission(String att_name, int level, String description, int cost, String method) {
		super(att_name, description, cost);
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
}

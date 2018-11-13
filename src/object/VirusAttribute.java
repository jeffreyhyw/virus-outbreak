package object;

public class VirusAttribute {
    private String att_name;
    private String description;
    private int cost;
    private boolean researched;

    public VirusAttribute(String att_name, String description, int cost) {
        this.att_name = att_name;
        this.description = description;
        this.cost = cost;
        this.researched = false;
    }

    public String getAtt_name() {
        return att_name;
    }

    public String getDescription() {
        return description;
    }

    public int getCost() {
        return cost;
    }

    public boolean getResearched() {
        return researched;
    }

    public void setResearched(boolean researched) {
        this.researched = researched;
    }


}

package object;

public class InfectedCountry implements CountryState {
	private boolean all = false;
    public void handle() {
    }
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = true;
	}
    
}
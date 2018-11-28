package object;

public class NormalCountry implements CountryState {
	private boolean all = true;
    public void handle() {
    }
	public boolean isAll() {
		return all;
	}
	public void setAll(boolean all) {
		this.all = all;
	}
}
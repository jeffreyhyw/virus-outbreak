package object;

public class DeadCountry implements CountryState {
	private boolean all = false;

	@Override
	public boolean isAll() {
		return all;
	}

	@Override
	public void setAll(boolean all) {
		this.all = all;
	}
}
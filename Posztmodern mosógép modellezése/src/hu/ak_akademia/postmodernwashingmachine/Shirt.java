package hu.ak_akademia.postmodernwashingmachine;

public class Shirt extends Cloth implements Washable {

	public Shirt(ColorOfTheCloth colorOfTheCloth, String nameOfTheCloth, int dirtiness, boolean isIroned,
			boolean isTorn, int wet) {
		super(colorOfTheCloth, nameOfTheCloth, dirtiness, isIroned, isTorn, wet);
	}

	@Override
	public void clean() {
		if (dirtiness > 0) {
			this.dirtiness = this.dirtiness - 1;
		}

		if (getDurability() > 0) {
			setDurability(getDurability() - 2);
		}

		if (getDurability() == 0) {
			setTorn();
		}
	}

	@Override
	public void dry() {

	}

	@Override
	public void iron() {

	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public boolean isWashable() {
		return !isTorn();
	}
}

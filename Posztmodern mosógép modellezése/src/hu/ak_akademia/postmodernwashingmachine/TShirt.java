package hu.ak_akademia.postmodernwashingmachine;

public class TShirt extends Cloth implements Washable {

	public TShirt(ColorOfTheCloth colorOfTheCloth, String nameOfTheCloth, int dirtiness, boolean isIroned,
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
		System.out.println("TShirt dry metódusa lefutott!");
	}

	@Override
	public void iron() {
		System.out.println("TShirt iron metódusa lefutott!");
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

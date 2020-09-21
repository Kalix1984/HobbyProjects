package hu.ak_akademia.postmodernwashingmachine;

public class Cloth {
	private ColorOfTheCloth colorOfTheCloth;
	private String nameOfTheCloth;
	protected int dirtiness;
	private int durability;
	private boolean isIroned;
	private boolean isTorn;
	private int wet;

	public Cloth(ColorOfTheCloth colorOfTheCloth, String nameOfTheCloth, int dirtiness, boolean isIroned,
			boolean isTorn, int wet) {
		this.colorOfTheCloth = colorOfTheCloth;
		this.nameOfTheCloth = nameOfTheCloth;
		this.dirtiness = dirtiness;
		this.isIroned = isIroned;
		this.isTorn = isTorn;
		this.wet = wet;
		this.durability = 100;
	}

	public int getDurability() {
		return durability;
	}

	public boolean isTorn() {
		return isTorn;
	}

	public void setTorn() {
		this.isTorn = true;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public void setIronedTrue() {
		this.isIroned = true;
	}

	public void setWet() {
		this.wet = 0;
	}

	public ColorOfTheCloth getColorOfTheCloth() {
		return colorOfTheCloth;
	}

	public int getDirtiness() {
		return dirtiness;
	}

	public void clean() {
		System.out.println("Eredeti Cloth.clean lefutott!");
	}

	@Override
	public String toString() {
		StringBuilder text = new StringBuilder();
		text.append("Ruhadarab:\n");
		text.append("  Neve: ").append(nameOfTheCloth).append("\n");
		text.append("  Típusa: ").append(colorOfTheCloth == ColorOfTheCloth.COLOR ? "Színes" : "Fehér").append("\n");
		text.append("  Piszkosság mértéke: ").append(dirtiness).append("\n");
		text.append("  Tartósság mértéke: ").append(durability).append("\n");
		text.append("  Szakadt: ").append(isTorn ? "igen" : "nem").append("\n");
		text.append("  Nedvesség: ").append(wet).append("\n");
		text.append("  Vasalva: ").append(isIroned ? "igen" : "nem").append("\n");

		return text.toString();
	}
}

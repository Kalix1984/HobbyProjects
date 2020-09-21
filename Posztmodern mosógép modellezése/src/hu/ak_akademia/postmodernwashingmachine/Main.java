package hu.ak_akademia.postmodernwashingmachine;

public class Main {

	public static void main(String[] args) {
		Jeans blackLevisJeans = new Jeans(ColorOfTheCloth.COLOR, "Levis fekete farmernadrág", 50, false, false, 10);
		Jeans blueMustangJeans = new Jeans(ColorOfTheCloth.COLOR, "Mustang kék farmernadrág", 10, false, false, 5);
		TShirt blackAdidasTShirt = new TShirt(ColorOfTheCloth.COLOR, "Adidas fekete póló", 40, false, false, 30);
		TShirt whiteKelvinKleinTShirt = new TShirt(ColorOfTheCloth.WHITE, "KelvinKlein fehér póló", 10, false, false,
				0);

		Cloth[] cloths = new Cloth[] { blackAdidasTShirt, blueMustangJeans, blackLevisJeans };

		PostModernWashingMachine AEG_X4000 = new PostModernWashingMachine();

		System.out.println("Szennyes ruhák: ");
		for (Cloth cloth : cloths) {
			System.out.println(cloth);
		}

		AEG_X4000.switchOn();
		AEG_X4000.open();
		AEG_X4000.load(cloths);
		AEG_X4000.close();
		AEG_X4000.startWash();
		AEG_X4000.dry();
		AEG_X4000.iron();
		AEG_X4000.open();
		AEG_X4000.unload();
		AEG_X4000.switchOff();

		System.out.println();
		System.out.println("Teregetnivaló ruhák: ");
		for (Cloth cloth : cloths) {
			System.out.println(cloth);
		}
	}
}

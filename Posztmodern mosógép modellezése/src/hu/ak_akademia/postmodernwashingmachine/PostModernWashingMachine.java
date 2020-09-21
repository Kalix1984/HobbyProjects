package hu.ak_akademia.postmodernwashingmachine;

public class PostModernWashingMachine {

	private boolean isPowerOn;
	private boolean isDoorOpen;
	private StatusOfPostModernWashingMachine status;
	private Cloth[] lanundry;

	public void setStatus(StatusOfPostModernWashingMachine status) {
		this.status = status;
	}

	public void switchOn() {

		if (isPowerOn) {
			System.out.println("Már be van kapcsolva");
		} else {
			isPowerOn = true;
			System.out.println("Mosógép bekapcsolva");
		}
	}

	public void switchOff() {
		if (!isPowerOn) {
			System.out.println("Már ki van kapcsolva");
		} else {
			isPowerOn = false;
			System.out.println("Mosógép kikapcsolva");
		}
	}

	public void open() {
		if (status == StatusOfPostModernWashingMachine.WASHING_IN_PROGRESS) {
			System.out.println("Mosás folyamatban az ajtó nem nyitható ki");
		} else {
			isDoorOpen = true;
			System.out.println("Mosógép ajtó kinyitva");
		}
	}

	public void close() {
		if (!isDoorOpen) {
			System.out.println("Az ajtó már zárva van");
		} else {
			isDoorOpen = false;
			System.out.println("Mosógép ajtó bezárva");
		}
	}

	public void load(Cloth[] cloth) {
		lanundry = cloth;
		System.out.println("Ruhák betöltve");
	}

	public void unload() {
		if (isDoorOpen && status != StatusOfPostModernWashingMachine.WASHING_IN_PROGRESS) {
			lanundry = null;
			System.out.println("Ruhák kiszedve");
		} else if (status == StatusOfPostModernWashingMachine.WASHING_IN_PROGRESS) {
			System.out.println("A mosás még folyamatban.");
		} else if (!isDoorOpen) {
			System.out.println("Az ajtó zárva nem tudom kiszedni a ruhákat");
		}
	}

	public void iron() {
		if (isPowerOn && !isDoorOpen && status == StatusOfPostModernWashingMachine.POWER_ON) {
			for (Cloth cloth : lanundry) {
				cloth.setIronedTrue();
				System.out.println("Ruhák vasalása");
			}
		}
	}

	public void dry() {
		if (isPowerOn && !isDoorOpen && status == StatusOfPostModernWashingMachine.POWER_ON) {
			for (Cloth cloth : lanundry) {
				cloth.setWet();
				System.out.println("Ruhák szárítása");
			}
		}
	}

	public String check() {
		if (isDoorOpen) {
			return "Az ajtó nyitva!";
		}

		if (lanundry == null || lanundry.length == 0) {
			return "Nincs egy betöltött ruha se a gépben.";
		}

		if (isMixedColorTypesInMachine()) {
			return "A gépbe fehér és színes ruhák is betöltésre kerültek.";
		}

		if (sumDirtiness() > 800) {
			return "A gépbe töltött ruhák összkoszossága meghaladja a 800-as értéket.";
		}

		if (sumDirtiness() < 50) {
			return "A gépbe töltött ruhák összkoszossága nem éri el az 50-es értéket.";
		}

		return "OK";
	}

	public void startWash() {
		if (isPowerOn) {
			System.out.println("Ellenőrzés eredménye: " + check());
		}
		if (check() == "OK" && isPowerOn) {
			setStatus(StatusOfPostModernWashingMachine.WASHING_IN_PROGRESS);
			System.out.println("Mosás indítása");
			while (sumDirtiness() >= 30) {
				System.out.println("Ruhák piszkossága összesítve: " + sumDirtiness());
				try {
					Thread.sleep(1000);
					for (Cloth cloth : lanundry) {
						cloth.clean();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			setStatus(StatusOfPostModernWashingMachine.POWER_ON);
			System.out.println();
			System.out.println("Vége a mosásnak");
			System.out.println();
		}
	}

	private boolean isMixedColorTypesInMachine() {
		int numberOfCloths = lanundry.length;

		if (numberOfCloths > 1) {
			ColorOfTheCloth first = lanundry[0].getColorOfTheCloth();
			int i = 1;
			while (i < numberOfCloths && first == lanundry[i].getColorOfTheCloth()) {
				i++;
			}
			if (i < numberOfCloths) {
				return true;
			}
		}
		return false;
	}

	private int sumDirtiness() {
		int sum = 0;
		for (Cloth cloth : lanundry) {
			sum += cloth.getDirtiness();
		}

		return sum;
	}
}

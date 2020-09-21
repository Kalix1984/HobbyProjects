
import java.util.Scanner;

public class InputFromUser {
	Scanner scan;

	public InputFromUser(Scanner scan) {
		this.scan = scan;
	}

	public int getInt(String message) {

		int number = 0;

		boolean isInt = false;
		do {
			System.out.print(message);

			if (scan.hasNextInt()) {
				number = scan.nextInt();
				scan.nextLine();
				isInt = true;

			} else {
				System.out.println("Nem egész számot adott meg");
				isInt = false;
				scan.next();
			}

		} while (!isInt);

		return number;
	}

	public int[] getIntArray(String message, int numberOfValues) {
		System.out.println(message);

		int[] numbers = new int[numberOfValues];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = getInt(i + 1 + ". szám: ");
		}

		return numbers;
	}

	public double getDouble(String message) {
		double number = 0;
		boolean isDouble = false;
		do {
			System.out.print(message);

			if (scan.hasNextDouble()) {
				number = scan.nextDouble();
				scan.nextLine();
				isDouble = true;

			} else {
				System.out.println("Nem valós számot adott meg");
				isDouble = false;
				scan.next();
			}

		} while (!isDouble);

		return number;
	}

	public double[] getDoubleArray(String message, int numberOfValues) {
		System.out.println(message);

		double[] numbers = new double[numberOfValues];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = getDouble(i + 1 + ". szám: ");
		}

		return numbers;
	}

	public String getString(String message) {
		System.out.print(message);
		String text = scan.nextLine();

		return text;
	}

	public String[] getStringArray(String message, int numberOfValues) {
		System.out.println(message);

		String[] texts = new String[numberOfValues];

		for (int i = 0; i < texts.length; i++) {
			texts[i] = getString(i + 1 + ". szöveg: ");
		}

		return texts;
	}

	public String getBoolean(String message) {

		return getString(message);
	}

	public String[] getBooleanArray(String message, int numberOfValues) {

		return getStringArray(message, numberOfValues);
	}
}

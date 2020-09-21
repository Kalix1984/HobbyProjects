
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// int
		int number1 = new InputFromUser(scan).getInt("Pozitív egész szám, ami páros és prím: ");
		System.out.println(
				"Valid: " + new ValidationForInt(number1).checkIntNotZero().checkIntEven().checkIntPrime().isValid());
		// double
		double number2 = new InputFromUser(scan).getDouble("Valós szám, ami nagyobb mint 10: ");
		System.out.println(new ValidationForDouble(number2).checkDoubleGreaterThan(10).isValid());
		// String
		String text1 = new InputFromUser(scan).getString("Szöveg ami csak számokat tartalmaz: ");
		System.out.println(new ValidationForString(text1).checkStringContainsOnlyNumbers().isValid());
		// "boolean"
		String choice = new InputFromUser(scan).getBoolean("igaz/I/true/hamis/H/false: ");
		System.out.println(new ValidationForBoolean(choice).checkContainsValidData().isValid());

		
		//Arrays
		int[] numbers = new InputFromUser(scan).getIntArray("4 természetes szám, ami 5 és 100 között van és páros: ",
				4);
		for (int number : numbers) {
			System.out.println("Valid: "
					+ new ValidationForInt(number).checkIntBetweenBoundaries(5, 100).checkIntEven().isValid());
		}

		String[] texts = new InputFromUser(scan)
				.getStringArray("2 db szöveg bevitele, amik hossza legalább 5 és legfeljebb 20: ", 2);
		for (String text : texts) {
			System.out.println("Valid: " + new ValidationForString(text).checkStringLength().isValid());
		}
	}
}

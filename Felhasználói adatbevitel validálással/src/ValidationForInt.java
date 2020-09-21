public class ValidationForInt {

	private int number;
	private boolean isValid;

	public ValidationForInt(int number) {
		this.number = number;
		isValid = true;
	}

	public boolean isValid() {
		return this.isValid;
	}

	public ValidationForInt checkIntPositive() {
		if (number <= 0) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntNegative() {
		if (number > 0) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntNotZero() {
		if (number == 0) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntBetweenBoundaries(int lowerBound, int upperBound) {
		if (number < lowerBound || number > upperBound) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntEven() {
		if (number % 2 != 0) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntOdd() {
		if (number % 2 == 0) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntPrime() {
		if (number < 2)
			isValid = false;

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				isValid = false;
			}
		}
		return this;
	}

	public ValidationForInt checkIntLessThan(int number2) {

		if (number >= number2) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntGreaterThan(int number2) {

		if (number <= number2) {
			isValid = false;
		}
		return this;
	}

	public ValidationForInt checkIntInTheList(int[] numbers) {
		boolean isInArray = false;
		for (int num : numbers) {
			if (num == number) {
				isInArray = true;
			}
		}

		if (!isInArray) {
			isValid = false;
		}
		return this;
	}
}

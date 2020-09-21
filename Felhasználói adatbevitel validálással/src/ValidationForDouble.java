public class ValidationForDouble {

	private double number;
	private boolean isValid;

	public ValidationForDouble(double number) {
		this.number = number;
		this.isValid = true;
	}

	public boolean isValid() {
		return isValid;
	}

	public ValidationForDouble checkDoublePositive() {
		if (number <= 0) {
			isValid = false;
		}

		return this;
	}

	public ValidationForDouble checkDoubleNegative() {
		if (number >= 0) {
			isValid = false;
		}

		return this;
	}

	public ValidationForDouble checkDoubleNotZero() {
		if (number == 0) {
			isValid = false;
		}

		return this;
	}

	public ValidationForDouble checkDoubleBetweenBoundaries(double lowerBound, double upperBound) {
		if (number < lowerBound || number > upperBound) {
			isValid = false;
		}

		return this;
	}

	public ValidationForDouble checkDoubleLessThan(double number2) {

		if (number >= number2) {
			isValid = false;
		}

		return this;
	}

	public ValidationForDouble checkDoubleGreaterThan(double number2) {

		if (number <= number2) {
			isValid = false;
		}

		return this;
	}
}

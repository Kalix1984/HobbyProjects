public class ValidationForString {

	private String text;
	private boolean isValid;

	public ValidationForString(String text) {
		this.text = text;
		isValid = true;
	}

	public boolean isValid() {
		return isValid;
	}

	public ValidationForString checkStringNotEmpty() {
		if (text.isEmpty()) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringEmpty() {
		if (!text.isEmpty()) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringLength() {
		if (text.length() < 5 || text.length() > 20) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsOnlyThisCharacters(String letters) {
		if (!text.matches("^[" + letters + "]+$")) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringNotContainsThisCharacters(String letters) {
		if (!text.matches("^[^" + letters + "]+$")) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringLengthLessThan(int length) {
		if (text.length() >= length) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringLengthGreaterThan(int length) {
		if (text.length() <= length) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsAllOfThisCharacters(String letters) {
		StringBuilder regex = new StringBuilder();
		regex.append(".*");

		for (int i = 0; i < letters.length(); i++) {
			regex.append(letters.charAt(i)).append(".*");
		}

		if (!text.matches(regex.toString())) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringAtLeastContainsOneOfThisCharacters(String letters) {
		
		if (!text.matches("\\w*[" + letters + "]\\w*")) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsWord(String word) {
		if (!text.matches(word)) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsOnlyLowercaseLetters() {
		if (!text.matches("^[a-z]+$")) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsOnlyUpperrcaseLetters() {
		if (!text.matches("^[A-Z]+$")) {
			isValid = false;
		}

		return this;
	}

	public ValidationForString checkStringContainsOnlyNumbers() {
		if (!text.matches("^[\\d]+$")) {
			isValid = false;
		}

		return this;
	}

}

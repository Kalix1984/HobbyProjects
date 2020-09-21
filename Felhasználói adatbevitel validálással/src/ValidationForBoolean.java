public class ValidationForBoolean {

	private boolean isValid;
	private String text;

	public ValidationForBoolean(String text) {
		this.isValid = true;
		this.text = text;
	}

	public boolean isValid() {
		return isValid;
	}

	public ValidationForBoolean checkContainsValidData() {
		if (!text.matches("(^igaz$|^true$|^I$)|(^hamis$|^false$|^H$)")) {
			this.isValid = false;
		}

		return this;
	}
}

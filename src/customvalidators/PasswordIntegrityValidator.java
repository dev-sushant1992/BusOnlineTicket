package customvalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class PasswordIntegrityValidator extends FieldValidatorSupport {
	static Pattern specialCharsDefaultPattern = Pattern.compile("!@#$");
	private String specialCharacters;

	public String getSpecialCharacters() {
		return specialCharacters;
	}

	public void setSpecialCharacters(String specialCharacters) {

		this.specialCharacters = specialCharacters;
	}

	public PasswordIntegrityValidator() {

	}

	@Override
	public void validate(Object object) throws ValidationException {
		// TODO Auto-generated method stub
		String fieldName = getFieldName();
		String fieldValue = (String) getFieldValue(fieldName, object);
		fieldValue = fieldValue.trim();
		Matcher specialCharacterMatcher;

		if (getSpecialCharacters() != null) 
		{
			Pattern specialPattern = Pattern.compile("["
					+ getSpecialCharacters() + "]");
			specialCharacterMatcher = specialPattern.matcher(fieldValue);
		} else 
		{
			specialCharacterMatcher = specialCharsDefaultPattern
					.matcher(fieldValue);
		}
		if (!specialCharacterMatcher.find()) {
			addFieldError(fieldName, object);
		}

	}

	public static Pattern getSpecialCharsDefaultPattern() {
		return specialCharsDefaultPattern;
	}

	public static void setSpecialCharsDefaultPattern(
			Pattern specialCharsDefaultPattern) {
		PasswordIntegrityValidator.specialCharsDefaultPattern = specialCharsDefaultPattern;
	}

}

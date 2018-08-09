package customvalidators;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class TimeFormatValidator extends FieldValidatorSupport{

	@Override
	public void validate(Object object) throws ValidationException {
		String fieldName = getFieldName();
		String fieldValue = (String)getFieldValue(fieldName, object);
		String[] values = fieldValue.split(":");
		try {
			int hrs = Integer.parseInt(values[0]);
			int mins = Integer.parseInt(values[1]);
			
			if(hrs > 23 || hrs < 0 || mins > 59 || mins < 0)
			{
				addFieldError(fieldName, object);
			}
		} catch (NumberFormatException e) {
			System.out.println("Exception");
			addActionError(object);
			e.printStackTrace();
		}		
	}
}

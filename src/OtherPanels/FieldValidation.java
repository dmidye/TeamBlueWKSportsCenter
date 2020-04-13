package OtherPanels;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class FieldValidation {

	//email validation
	boolean validateEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	 }
	
	//birthday validation
//
	final static String DATE_FORMAT = "yyyy-MM-dd";

	boolean dateValidation(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
        	e.printStackTrace();
            return false;
        }
	}
	
	boolean phoneValidation(String phone) {
		if(Pattern.matches("[0-9]{7}", phone)) {
			return true;
		}
		return false;
	}
}

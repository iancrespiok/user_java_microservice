package bci.evaluacion.user.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexValidator {
  private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
  private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?!.*[0-9]{3,})(?=.*[A-Z])(?!.*[A-Z]{2,})[a-zA-Z0-9]{8,12}$";

  public static boolean validateMail(String emailToValidate) {
    Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(emailToValidate);
    return matcher.matches();
  }

  public static boolean validatePassword(String passwordToValidate) {
    Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    Matcher matcher = pattern.matcher(passwordToValidate);
    return matcher.matches();
  }
}

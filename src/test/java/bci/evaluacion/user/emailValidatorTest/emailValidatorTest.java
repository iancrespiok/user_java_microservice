package bci.evaluacion.user.emailValidatorTest;

import bci.evaluacion.user.validators.RegexValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class emailValidatorTest {
  RegexValidator regexValidator = new RegexValidator();

  @Test
  public void testValidMail() {
    assertTrue(regexValidator.validateMail("crespi.ian@gmail.com"));
    assertFalse(regexValidator.validateMail("crespi.ian.com"));
    assertFalse(regexValidator.validateMail("crespi@.com"));
  }

  @Test
  public void testValidPassword() {
    assertTrue(regexValidator.validatePassword("aAa23dss"));
  }
}

package bci.evaluacion.user.emailValidatorTest;

import bci.evaluacion.user.validators.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class emailValidatorTest {
  EmailValidator emailValidator = new EmailValidator();

  @Test
  public void testValidMail() {
    assertTrue(emailValidator.validate("crespi.ian@gmail.com"));
    assertFalse(emailValidator.validate("crespi.ian.com"));
    assertFalse(emailValidator.validate("crespi@.com"));
  }
}

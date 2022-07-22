package bci.evaluacion.user.exceptions;

import bci.evaluacion.user.dtos.ErrorDTO;
import bci.evaluacion.user.dtos.ErrorsDTO;
import java.util.List;

public class NotValidUserException extends RuntimeException {
  private List<ErrorDTO> errors;

  public NotValidUserException(List<ErrorDTO> errors) {
    super("Not valid user exception");
    this.errors = errors;
  }

  public List<ErrorDTO> getErrors() {
    return errors;
  }

  public void setErrors(List<ErrorDTO> errors) {
    this.errors = errors;
  }
}

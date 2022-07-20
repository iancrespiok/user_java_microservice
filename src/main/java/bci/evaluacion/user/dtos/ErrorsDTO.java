package bci.evaluacion.user.dtos;

import java.util.ArrayList;

public class ErrorsDTO {
  public ArrayList<ErrorDTO> error;

  public ArrayList<ErrorDTO> getError() {
    return error;
  }

  public void setError(ArrayList<ErrorDTO> error) {
    this.error = error;
  }
}

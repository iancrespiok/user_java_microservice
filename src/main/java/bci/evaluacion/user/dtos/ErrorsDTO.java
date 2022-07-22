package bci.evaluacion.user.dtos;

import java.util.ArrayList;
import java.util.List;

public class ErrorsDTO {
  List<ErrorDTO> error = new ArrayList<>();

  public List<ErrorDTO> getError() {
    return error;
  }

  public void setError(List<ErrorDTO> error) {
    this.error = error;
  }
}

package bci.evaluacion.user.dtos;

import java.time.LocalDate;

public class ErrorDTO {
  public LocalDate timestamp;
  public Integer codigo;
  public String detail;

  public ErrorDTO(LocalDate timestamp, Integer codigo, String detail) {
    this.timestamp = timestamp;
    this.codigo = codigo;
    this.detail = detail;
  }

  public LocalDate getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDate timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getCodigo() {
    return codigo;
  }

  public void setCodigo(Integer codigo) {
    this.codigo = codigo;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}

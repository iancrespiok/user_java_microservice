package bci.evaluacion.user.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDTO {
  private LocalDateTime timestamp;
  private Integer codigo;
  private String detail;

  public ErrorDTO(LocalDateTime timestamp, Integer codigo, String detail) {
    this.timestamp = timestamp;
    this.codigo = codigo;
    this.detail = detail;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
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

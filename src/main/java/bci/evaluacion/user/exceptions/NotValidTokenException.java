package bci.evaluacion.user.exceptions;

import java.time.LocalDateTime;

public class NotValidTokenException extends RuntimeException {
  private Integer codigo;
  private String detail;
  private LocalDateTime timestamp;

  public NotValidTokenException(Integer codigo, String detail, LocalDateTime timestamp) {
    this.codigo = codigo;
    this.detail = detail;
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

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}

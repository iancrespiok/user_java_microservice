package bci.evaluacion.user.validators;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Error {
  public LocalDate timestamp;
  public Integer codigo;
  public String detail;

  public Error(LocalDate timestamp, Integer codigo, String detail) {
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

  public Map<String, Object> toMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("timestamp", getTimestamp());
    map.put("codigo", getCodigo());
    map.put("detail", getDetail());
    return map;
  }
}

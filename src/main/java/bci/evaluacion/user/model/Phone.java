package bci.evaluacion.user.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone extends PersistentEntity {
  private Long number;
  private Integer citycode;
  private String contrycode;

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Integer getCitycode() {
    return citycode;
  }

  public void setCitycode(Integer cityCode) {
    this.citycode = cityCode;
  }

  public String getContrycode() {
    return contrycode;
  }

  public void setContrycode(String countryCode) {
    this.contrycode = countryCode;
  }
}

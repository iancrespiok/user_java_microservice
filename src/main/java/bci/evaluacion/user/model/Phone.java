package bci.evaluacion.user.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phone extends PersistentEntity {
  public Long number;
  public Integer cityCode;
  public String countryCode;

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Integer getCityCode() {
    return cityCode;
  }

  public void setCityCode(Integer cityCode) {
    this.cityCode = cityCode;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
}

package bci.evaluacion.user.dtos;

import bci.evaluacion.user.model.Phone;

public class PhoneDTO {
  private Long number;
  private Integer citycode;
  private String contrycode;

  public PhoneDTO() {
  }

  public PhoneDTO(Phone phone) {
    this.number = phone.getNumber();
    this.citycode = phone.getCitycode();
    this.contrycode = phone.getContrycode();
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Integer getCitycode() {
    return citycode;
  }

  public void setCitycode(Integer citycode) {
    this.citycode = citycode;
  }

  public String getContrycode() {
    return contrycode;
  }

  public void setContrycode(String contrycode) {
    this.contrycode = contrycode;
  }
}

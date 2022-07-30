package bci.evaluacion.user.model;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

import bci.evaluacion.user.dtos.PhoneDTO;
import bci.evaluacion.user.model.User;

@Entity
public class Phone extends PersistentEntity {
  private Long number;
  private Integer citycode;
  private String contrycode;
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Phone() {
  }

  public Phone(PhoneDTO phoneDTO, User user) {
    this.number = phoneDTO.getNumber();
    this.citycode = phoneDTO.getCitycode();
    this.contrycode = phoneDTO.getContrycode();
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

package bci.evaluacion.user.model;

import bci.evaluacion.user.dtos.SignUpRequestDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends PersistentEntity {

  private String name;
  private String email;
  private String password;
  private LocalDateTime lastLogin;
  private LocalDateTime created;
  private Boolean isActive;
  @OneToMany
  private List<Phone> phones = new ArrayList<Phone>();

  public User() {
  }

  public User(SignUpRequestDTO signUpRequestDTO, String encodedPassword) {
    this.setEmail(signUpRequestDTO.getEmail());
    this.setPassword(encodedPassword);
    this.setCreated(LocalDateTime.now());
    this.setLastLogin(LocalDateTime.now());
    this.setActive(true);
    if (signUpRequestDTO.getName() != null)
      this.setName(signUpRequestDTO.getName());
    if (!signUpRequestDTO.getPhones().isEmpty())
      this.setPhones(signUpRequestDTO.getPhones());
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(LocalDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }
}

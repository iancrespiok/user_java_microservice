package bci.evaluacion.user.dtos;

import bci.evaluacion.user.model.Phone;
import bci.evaluacion.user.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserResponseDTO {
  private UUID id;
  private LocalDateTime created;
  private LocalDateTime lastLogin;
  private String token;
  private Boolean isActive;
  private String name;
  private String email;
  private String password;
  private List<PhoneDTO> phones = new ArrayList<>();

  public UserResponseDTO(User user, String token) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.password = user.getPassword();
    if(user.getName() != null)
      this.name = user.getName();
    this.phones = user.getPhones().stream().map(PhoneDTO::new).collect(Collectors.toList());
    this.created = user.getCreated();
    this.isActive = user.getActive();
    this.lastLogin = user.getLastLogin();
    this.token = token;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public LocalDateTime getCreated() {
    return created;
  }

  public void setCreated(LocalDateTime created) {
    this.created = created;
  }

  public LocalDateTime getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(LocalDateTime lastLogin) {
    this.lastLogin = lastLogin;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
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

  public List<PhoneDTO> getPhones() {
    return phones;
  }

  public void setPhones(List<PhoneDTO> phones) {
    this.phones = phones;
  }
}

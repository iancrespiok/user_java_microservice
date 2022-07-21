package bci.evaluacion.user.service;

import bci.evaluacion.user.dtos.UserDTO;
import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.UserRepository;
import bci.evaluacion.user.security.JWTProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JWTProvider jwtProvider;

  public ArrayList<User> getUsers() {
    return (ArrayList<User>) userRepository.findAll();
  }

  public User createUser(UserDTO userDTO){
    User user = new User();
    user.setEmail(userDTO.getEmail());
    String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
    user.setPassword(encryptedPassword);
    user.setCreated(LocalDate.now());
    user.setActive(true);
    return userRepository.save(user);
  }
}

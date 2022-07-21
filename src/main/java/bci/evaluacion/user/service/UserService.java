package bci.evaluacion.user.service;

import bci.evaluacion.user.dtos.ErrorDTO;
import bci.evaluacion.user.dtos.ErrorsDTO;
import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.UserRepository;
import bci.evaluacion.user.security.JWTProvider;
import bci.evaluacion.user.validators.RegexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

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

  public User createUser(User user){
    user.setCreated(LocalDate.now());

    ErrorsDTO errors = new ErrorsDTO();

    if (!RegexValidator.validateMail(user.email)) {
      errors.getError().add(new ErrorDTO(LocalDate.now(), 1, "Given email is not correct"));
    }

    if (!RegexValidator.validateMail(user.email)) {

    }

    if (getUsers().stream().anyMatch(u -> u.getEmail() == user.getEmail())) {

    }
    return userRepository.save(user);
  }
}

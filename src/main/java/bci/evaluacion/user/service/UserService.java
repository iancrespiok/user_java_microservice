package bci.evaluacion.user.service;

import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public ArrayList<User> getUsers() {
    return (ArrayList<User>) userRepository.findAll();
  }

  public User createUser(User user){
    return userRepository.save(user);
  }
}

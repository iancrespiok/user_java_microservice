package bci.evaluacion.user.controller;

import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.PhoneRepository;
import bci.evaluacion.user.service.PhoneService;
import bci.evaluacion.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
  @Autowired
  UserService userService;
  @Autowired
  PhoneService phoneService;

  @GetMapping()
  public ArrayList<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    user.getPhones().forEach(p -> {
      phoneService.createPhone(p);
    });
    return userService.createUser(user);
  }
}

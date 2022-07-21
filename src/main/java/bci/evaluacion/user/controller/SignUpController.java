package bci.evaluacion.user.controller;

import bci.evaluacion.user.dtos.UserDTO;
import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.PhoneRepository;
import bci.evaluacion.user.security.JWTProvider;
import bci.evaluacion.user.service.PhoneService;
import bci.evaluacion.user.service.UserService;
import bci.evaluacion.user.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
  @Autowired
  UserService userService;
  @Autowired
  PhoneService phoneService;
  @Autowired
  UserValidator userValidator;
  @Autowired
  JWTProvider jwtProvider;

  @GetMapping()
  public ArrayList<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public ResponseEntity<Map<String,Object>> createUser(@RequestBody UserDTO userDTO) {
    Map<String, Object> errors = userValidator.validateUser(userDTO);
    if(errors != null) {
      return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    } else {
      userDTO.getPhones().forEach(p -> {
        phoneService.createPhone(p);
      });
      Map<String, Object> response = new HashMap<>();
      User user = userService.createUser(userDTO);
      response.put("id", user.getId());
      response.put("email", user.getEmail());
      response.put("password", user.getPassword());
      response.put("created", user.getCreated());
      response.put("lastLogin", user.getLastLogin());
      response.put("token", jwtProvider.createToken(user));
      response.put("isActive", user.getActive());

      return new ResponseEntity<>(response, HttpStatus.OK);
    }
  }
}

package bci.evaluacion.user.controller;

import bci.evaluacion.user.model.User;
import bci.evaluacion.user.security.JWTProvider;
import bci.evaluacion.user.validators.Error;

import bci.evaluacion.user.service.PhoneService;
import bci.evaluacion.user.service.UserService;
import bci.evaluacion.user.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {
  @Autowired
  UserService userService;
  @Autowired
  JWTProvider jwtProvider;

  @GetMapping
  public ResponseEntity<Map<String,Object>> getAuthenticatedUser(HttpServletRequest httpServletRequest) {
    Map<String, Object> response = new HashMap<>();

    String authToken = httpServletRequest.getHeader("token");
    String mail = jwtProvider.getMailFromToken(authToken);
    Optional<User> user = userService.getUsers().stream().filter(u -> u.getEmail() == mail).findFirst();

    if (!user.isPresent()){
      Error notValidTokenError = new Error(LocalDate.now(), 1, "Given token is not valid");
      List<Map<String,Object>> errors = new ArrayList<>();
      errors.add(notValidTokenError.toMap());
      response.put("errors", errors);
      return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    } else {
      response.put("id", user.get().getId());
      response.put("email", user.get().getEmail());
      response.put("password", user.get().getPassword());
      response.put("created", user.get().getCreated());
      response.put("lastLogin", user.get().getLastLogin());
      response.put("token", jwtProvider.createToken(user.get()));
      response.put("isActive", user.get().getActive());
      return new ResponseEntity<>(response, HttpStatus.OK);
    }
  }
}

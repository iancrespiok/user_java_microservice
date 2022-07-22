package bci.evaluacion.user.controller;

import bci.evaluacion.user.dtos.ErrorDTO;
import bci.evaluacion.user.dtos.ErrorsDTO;
import bci.evaluacion.user.dtos.SignUpRequestDTO;
import bci.evaluacion.user.exceptions.NotValidUserException;
import bci.evaluacion.user.model.User;
import bci.evaluacion.user.security.JWTProvider;
import bci.evaluacion.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sign-up")
public class SignUpController {
  @Autowired
  UserService userService;

  @Autowired
  JWTProvider jwtProvider;

  @GetMapping()
  public ArrayList<User> getUsers() {
    return userService.getUsers();
  }

  @PostMapping
  public ResponseEntity<?> createUser(@RequestBody SignUpRequestDTO userDTO) {
    try {
      return ResponseEntity.ok(userService.createUser(userDTO));
    } catch (NotValidUserException notValidUserException) {
      ErrorsDTO errorsDTO = new ErrorsDTO();
      List<ErrorDTO> errors = notValidUserException.getErrors();
      errorsDTO.getError().addAll(errors);
      return ResponseEntity.badRequest().body(errorsDTO);
    }
  }
}

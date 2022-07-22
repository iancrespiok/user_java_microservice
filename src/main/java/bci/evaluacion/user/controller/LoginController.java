package bci.evaluacion.user.controller;

import bci.evaluacion.user.dtos.ErrorDTO;
import bci.evaluacion.user.dtos.ErrorsDTO;
import bci.evaluacion.user.exceptions.NotValidTokenException;
import bci.evaluacion.user.security.JWTProvider;

import bci.evaluacion.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/login")
public class LoginController {
  @Autowired
  UserService userService;
  @Autowired
  JWTProvider jwtProvider;

  @GetMapping
  public ResponseEntity<?> getAuthenticatedUser(HttpServletRequest httpServletRequest) {
    try {
      String authToken = httpServletRequest.getHeader("token");
      return ResponseEntity.ok(userService.getUserByToken(authToken));
    } catch (NotValidTokenException notValidTokenException) {
      ErrorsDTO errorsDTO = new ErrorsDTO();
      errorsDTO.getError().add(new ErrorDTO(notValidTokenException.getTimestamp(), notValidTokenException.getCodigo(), notValidTokenException.getDetail()));
      return ResponseEntity.badRequest().body(errorsDTO);
    } catch (Exception exception) {
      ErrorsDTO errorsDTO = new ErrorsDTO();
      errorsDTO.getError().add(new ErrorDTO(LocalDateTime.now(), 1, exception.getMessage()));
      return ResponseEntity.status(500).body(errorsDTO);
    }
  }
}

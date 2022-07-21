package bci.evaluacion.user.validators;

import bci.evaluacion.user.dtos.UserDTO;
import bci.evaluacion.user.service.UserService;
import org.hibernate.hql.internal.ast.ErrorReporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserValidator {
  @Autowired
  UserService userService;

  public Map<String, Object> validateUser(UserDTO user) {
    Map<String, Object> errors = new HashMap<>();
    List<Map<String, Object>> errorsList = new ArrayList<>();

    if (!RegexValidator.validateMail(user.getEmail())) {
      Error mailError = new Error(LocalDate.now(), 1, "Given email is not correct");
      errorsList.add(mailError.toMap());
    }
    if (!RegexValidator.validatePassword(user.getPassword())) {
      Error passwordError = new Error(LocalDate.now(), 1, "Given password doesn't meet the requirements");
      errorsList.add(passwordError.toMap());
    }
    if (userService.getUsers().stream().anyMatch(u -> u.getEmail() == user.getEmail())) {
      Error userAlreadyExistsError = new Error(LocalDate.now(), 1, "Given email is already register with another user");
      errorsList.add(userAlreadyExistsError.toMap());
    }

    if(errorsList.isEmpty()){
      return null;
    } else {
      errors.put("errors", errorsList);
      return errors;
    }

  }
}

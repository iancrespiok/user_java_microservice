package bci.evaluacion.user.service;

import bci.evaluacion.user.dtos.ErrorDTO;
import bci.evaluacion.user.dtos.SignUpRequestDTO;
import bci.evaluacion.user.dtos.UserResponseDTO;
import bci.evaluacion.user.exceptions.NotValidTokenException;
import bci.evaluacion.user.exceptions.NotValidUserException;
import bci.evaluacion.user.model.User;
import bci.evaluacion.user.repositories.UserRepository;
import bci.evaluacion.user.security.JWTProvider;
import bci.evaluacion.user.validators.RegexValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  JWTProvider jwtProvider;

  @Autowired
  PhoneService phoneService;

  public ArrayList<User> getUsers() {
    return (ArrayList<User>) userRepository.findAll();
  }

  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  public UserResponseDTO createUser(SignUpRequestDTO signUpRequestDTO){
    validateUser(signUpRequestDTO);
    signUpRequestDTO.getPhones().forEach(p -> {
        phoneService.createPhone(p);
    });
    User user = new User(signUpRequestDTO, passwordEncoder.encode(signUpRequestDTO.getPassword()));
    userRepository.save(user);
    String token = jwtProvider.createToken(user);
    return new UserResponseDTO(user, token);
  }

  public UserResponseDTO getUserByToken(String authToken) {
    String email = jwtProvider.getEmailFromToken(authToken);
    Optional<User> user = findByEmail(email);

    if (!user.isPresent())
      throw new NotValidTokenException(1, "Given token is not valid", LocalDateTime.now());

    String newToken = jwtProvider.createToken(user.get());
    return new UserResponseDTO(user.get(), newToken);
  }

  public void validateUser(SignUpRequestDTO signUpRequestDTO) {
    List<ErrorDTO> errorsList = new ArrayList<>();

    if (!RegexValidator.validateMail(signUpRequestDTO.getEmail()))
      errorsList.add(new ErrorDTO(LocalDateTime.now(), 1, "Given email is not correct"));
    if (!RegexValidator.validatePassword(signUpRequestDTO.getPassword()))
      errorsList.add(new ErrorDTO(LocalDateTime.now(), 1, "Given password doesn't meet the requirements"));
    if (findByEmail(signUpRequestDTO.getEmail()).isPresent())
      errorsList.add(new ErrorDTO(LocalDateTime.now(), 1, "Given email is already register with another user"));

    if(!errorsList.isEmpty()){
      throw new NotValidUserException(errorsList);
    }
  }
}

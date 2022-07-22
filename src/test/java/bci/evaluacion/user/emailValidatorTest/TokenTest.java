package bci.evaluacion.user.emailValidatorTest;

import bci.evaluacion.user.model.User;
import bci.evaluacion.user.security.JWTProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class TokenTest {
  JWTProvider jwtProvider = new JWTProvider("hola");

  @Test
  public void creatUserAndMatchToken(){
    User user = new User();
    String email = "crespi.ian@gmail.com";
    user.setEmail(email);
    user.setPassword("holahola");
    user.setId(Long.valueOf(1));
   // user.setId(UUID.randomUUID());
    String token = jwtProvider.createToken(user);
    assertEquals(jwtProvider.getEmailFromToken(token), email);
  }
}

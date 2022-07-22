package bci.evaluacion.user.security;

import bci.evaluacion.user.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTProvider {
  @Value("${jwt.secret}")
  private String secret;

  @PostConstruct
  protected void init() {
    secret = Base64.getEncoder().encodeToString(secret.getBytes());
  }

  public String createToken(User user) {
    Map<String, Object> claims = new HashMap<>();
    claims = Jwts.claims().setSubject(user.getEmail());
    claims.put("id", user.getId());
    claims.put("creationMoment", LocalDateTime.now().toString());
    return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secret).compact();
  }

  public String getEmailFromToken(String token) {
    try {
      return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    } catch (Exception e) {
      return "Bad Token";
    }
  }
}

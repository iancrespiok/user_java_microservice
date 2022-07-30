package bci.evaluacion.user.model;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class PersistentEntity {
 // @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id  @GeneratedValue
  private UUID id;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}

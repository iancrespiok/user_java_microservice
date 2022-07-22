package bci.evaluacion.user.model;

import javax.persistence.*;
import java.util.UUID;

@MappedSuperclass
public class PersistentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Long id;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

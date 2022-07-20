package bci.evaluacion.user.repositories;

import bci.evaluacion.user.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
}

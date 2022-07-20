package bci.evaluacion.user.service;

import bci.evaluacion.user.model.Phone;
import bci.evaluacion.user.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PhoneService {
  @Autowired
  PhoneRepository phoneRepository;

  public ArrayList<Phone> getPhones() {
    return (ArrayList<Phone>) phoneRepository.findAll();
  }

  public Phone createPhone(Phone phone){
    return phoneRepository.save(phone);
  }
}

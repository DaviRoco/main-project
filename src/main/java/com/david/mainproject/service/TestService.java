package com.david.mainproject.service;

import com.david.mainproject.dto.Testdto;
import com.david.mainproject.entity.Test;
import com.david.mainproject.exception.ErroreMessage;
import com.david.mainproject.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
  @Autowired
  TestRepository testRepository;

  public Iterable<Test> retrieve(){
    return testRepository.findAll();
  }

  public Test retrieveByID(String ID){
    return testRepository.getTestByID(ID);
  }

  public Test create(Testdto dto){
    Test test1 =
        Test.builder().descripcion(dto.getDescripcion()).build();

    return testRepository.save(test1);
  }

  public boolean existsId(String ID){
    return testRepository.existsById(ID);
  }
  public ErroreMessage getError(int tipo) {
    ErroreMessage errorMessage = new ErroreMessage();
    errorMessage.setMessageError(tipo);
    return errorMessage;
  }
}

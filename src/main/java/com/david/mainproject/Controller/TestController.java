package com.david.mainproject.Controller;

import com.david.mainproject.dto.Testdto;
import com.david.mainproject.entity.Test;
import com.david.mainproject.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class TestController {
  @Autowired
  TestService testService;

  @GetMapping("/test")
  public ResponseEntity<Iterable<Test>> list(){
    return ResponseEntity.ok(testService.retrieve());
  }

  @GetMapping("test/{ID}")
  public ResponseEntity<Test> getTestById(@PathVariable("ID") String ID){
    if (!testService.existsId(ID))
      return new ResponseEntity(testService.getError(1), HttpStatus.NOT_FOUND);
    return ResponseEntity.ok(testService.retrieveByID(ID));
  }

  @PostMapping("/test")
  public ResponseEntity<Test> create(@RequestBody Testdto testdto){
    if (!testService.existsId(testdto.getID()))
      return new ResponseEntity(testService.getError(2), HttpStatus.BAD_REQUEST);
    return ResponseEntity.ok(testService.create(testdto));
  }
}

package com.david.mainproject.repository;

import com.david.mainproject.entity.Test;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface TestRepository extends CrudRepository<Test, String> {
  Test getTestByID(String ID);

}

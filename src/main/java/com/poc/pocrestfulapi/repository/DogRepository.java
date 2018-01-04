package com.poc.pocrestfulapi.repository;

import com.poc.pocrestfulapi.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends CrudRepository<Dog,Long> {

    Dog findByName(String name);

}
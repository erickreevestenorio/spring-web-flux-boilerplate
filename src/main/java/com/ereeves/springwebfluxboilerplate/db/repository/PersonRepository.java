package com.ereeves.springwebfluxboilerplate.db.repository;

import com.ereeves.springwebfluxboilerplate.db.domain.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<Person, UUID> {
}

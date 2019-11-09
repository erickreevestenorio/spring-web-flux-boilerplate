package com.ereeves.springwebfluxboilerplate.web.rest.controller;

import com.ereeves.springwebfluxboilerplate.db.domain.Person;
import com.ereeves.springwebfluxboilerplate.db.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RecordReactiveController extends BaseController {

    private final PersonRepository recordRepository;

    @GetMapping(value = "/person/{uuid}")
    public Mono<Person> findByUuid(@PathVariable("uuid") UUID uuid) {
        return recordRepository.findById(uuid);
    }

    @PostMapping(value = "/person")
    public Mono<Person> savePerson(@RequestBody Person person) {
        return Mono.justOrEmpty(recordRepository.save(person).block());
    }

    @GetMapping(value = "/people")
    public Flux<Person> getAllPeople() {
        return recordRepository.findAll();
    }

}

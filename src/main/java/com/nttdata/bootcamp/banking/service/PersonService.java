package com.nttdata.bootcamp.banking.service;

import com.nttdata.bootcamp.banking.model.document.Person;
import reactor.core.publisher.Mono;

public interface PersonService {

    Mono<Person> insert(Person person);

    Mono<Person> findByCode(String code);

}

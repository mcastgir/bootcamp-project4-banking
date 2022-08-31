package com.nttdata.bootcamp.banking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.bootcamp.banking.model.document.Person;
import com.nttdata.bootcamp.banking.producer.KafkaProducer;
import com.nttdata.bootcamp.banking.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class PersonServiceImpl implements PersonService {

    private static final String API_PERSON = "/api/persons";
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier("WcPerson")
    private WebClient wcPerson;

    @Override
    public Mono<Person> insert(Person person) {
        try {
            kafkaProducer.sendMessageToTopic(objectMapper.writeValueAsString(person));
        } catch (Exception ex) {
            LOGGER.error(ex.toString());
        }
        return Mono.just(person);
    }

    @Override
    public Mono<Person> findByCode(String code) {
        return wcPerson.get()
                .uri (API_PERSON.concat("/findByCode/").concat(code))
                .retrieve()
                .bodyToMono(Person.class)
                .timeout(Duration.ofMillis(10_000))
                .doFirst(() -> LOGGER.info("Begin FindByCode Person"))
                .doOnNext(p -> LOGGER.info(p.toString()))
                .doAfterTerminate(() -> LOGGER.info("Finish FindByCode Person"));
    }

}

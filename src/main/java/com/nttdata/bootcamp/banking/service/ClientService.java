package com.nttdata.bootcamp.banking.service;

import com.nttdata.bootcamp.banking.model.document.Client;
import reactor.core.publisher.Mono;

public interface ClientService {

    Mono<Client> findByCode(String code);

}

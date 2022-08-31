package com.nttdata.bootcamp.banking.service;

import com.nttdata.bootcamp.banking.model.document.Product;
import reactor.core.publisher.Mono;

public interface ProductService {

    Mono<Product> findByCode(String code);

}

package com.nttdata.bootcamp.banking.model.dto;

import com.nttdata.bootcamp.banking.model.document.Person;
import lombok.Data;

@Data
public class HolderDto {

    private String accountNumber;
    private Person person;

}

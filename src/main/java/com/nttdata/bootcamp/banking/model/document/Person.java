package com.nttdata.bootcamp.banking.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Person {

    private String id;
    private String code;
    private String name;
    private String lastName;
    private String codeDocumentType;
    private String documentNumber;
    private String phoneNumber;
    private String email;
    private boolean state;

}

package com.joaoduraes.stream.drinking.processor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class Person {

    private String id;
    private String firstName;
    private String lastName;
    private Instant createdDate;
}

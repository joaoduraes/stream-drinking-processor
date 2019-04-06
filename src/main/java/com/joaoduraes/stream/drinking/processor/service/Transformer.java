package com.joaoduraes.stream.drinking.processor.service;

import com.joaoduraes.stream.drinking.processor.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.handler.annotation.SendTo;


@EnableBinding(Processor.class)
@MessageEndpoint
@Slf4j
public class Transformer {

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    Person transform(Person person) {

        Person newPerson = new Person(person.getId(),
                person.getFirstName().toUpperCase(),
                person.getLastName().toUpperCase(),
                person.getCreatedDate());

        log.info("Transformed " + person.toString() + " in " + newPerson.toString());

        return newPerson;
    }

}

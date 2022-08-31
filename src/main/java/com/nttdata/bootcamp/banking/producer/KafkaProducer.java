package com.nttdata.bootcamp.banking.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Value("${kafka.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessageToTopic(final String message) {
        kafkaTemplate.send(topic, message);
    }

}

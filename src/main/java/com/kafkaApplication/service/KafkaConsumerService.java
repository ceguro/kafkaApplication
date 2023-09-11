package com.kafkaApplication.service;

import com.kafkaApplication.model.Greeting;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "${message.topic.name.default}", groupId = "greeting", containerFactory = "greetingKafkaListenerContainerFactory")
    public void consumeMessage(Greeting greeting) {
        System.out.println("Received message: " + greeting.toString());
    }
}

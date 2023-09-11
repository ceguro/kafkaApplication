package com.kafkaApplication.service;

import com.kafkaApplication.model.Greeting;
import com.kafkaApplication.model.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Greeting> greetingKafkaTemplate;

    @Value("${message.topic.name.default}")
    private String defaultTopicName;

    public String sendMessage(MessageRequest message) {
        Greeting  greeting = new Greeting(message.getMessage(), "test");
        greetingKafkaTemplate.send(defaultTopicName, greeting);
        return "message sent to topic: " + defaultTopicName + " successfully with message: " + message.getMessage();
    }
}

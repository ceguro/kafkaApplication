package com.kafkaApplication.controller;

import com.kafkaApplication.model.MessageRequest;
import com.kafkaApplication.service.KafkaProducerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducerService kafkaProducerService;
    private static final Logger log = LogManager.getLogger(KafkaController.class);

    public KafkaController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/message")
    public ResponseEntity<String> setMessage(@RequestBody MessageRequest messageRequest) {
        log.info("message received: " + messageRequest.getMessage());
        String result = kafkaProducerService.sendMessage(messageRequest);
        log.info("message " + messageRequest.getMessage() + " sent to kafka topic");

        return ResponseEntity.ok(result);
    }
}

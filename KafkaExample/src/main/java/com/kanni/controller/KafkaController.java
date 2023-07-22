package com.kanni.controller;

import com.kanni.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class KafkaController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public static final String TOPIC_NAME = "Kafka_chat_demo";

    public KafkaController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/sendMessage")
    public String produce(@RequestBody  Message message) {
        log.info("Produce message tick: {}", message.getMessage());
        kafkaTemplate.send(TOPIC_NAME, message);
        return "Successfully sent message!!!";
    }
}

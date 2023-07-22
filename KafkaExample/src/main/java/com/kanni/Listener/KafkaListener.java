package com.kanni.Listener;

import com.kanni.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaListener {


    @org.springframework.kafka.annotation.KafkaListener(topics = "Kafka_chat_demo",groupId = "KK_test_1")
    public void printMessage(String message){

        log.info("First client Reading message: {}",message);
    }

    @org.springframework.kafka.annotation.KafkaListener(topics = "Kafka_chat_demo",groupId = "KK_test_2")
    public void printMessage2(String message){

        log.info("Two client Reading message: {}",message);
    }
}

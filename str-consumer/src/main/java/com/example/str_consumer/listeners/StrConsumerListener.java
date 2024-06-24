package com.example.str_consumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {
    @KafkaListener(groupId = "group-0", topics = "str-topic", containerFactory = "strContainerFactory")
    public void listener(String message){
        log.info("CREATE ::: Recieve message {}", message);
    }
    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void log(String message){
        log.info("LOG ::: Recieve message {}", message);
    }
    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: Recieve message {}", message);
    }
}
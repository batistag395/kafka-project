package com.example.str_consumer.listeners;

import com.example.str_consumer.Custom.StrConsumerCustomListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {
    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Recieve message {}", message);
    }
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message){
        log.info("CREATE ::: Recieve message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message){
        log.info("HISTORY ::: Recieve message {}", message);
    }
//    @KafkaListener(groupId = "group-0",
//            topicPartitions = {
//                @TopicPartition(topic = "str-topic", partitions = {"0"}),
//            },
//            containerFactory = "strContainerFactory")
//    public void log(String message){
//        log.info("LOG ::: Recieve message {}", message);
//    }
//    @KafkaListener(groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic = "str-topic", partitions = {"1"})
//            },
//            containerFactory = "strContainerFactory")
//    public void create(String message){
//        log.info("CREATE ::: Recieve message {}", message);
//    }
//
//    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
//    public void history(String message){
//        log.info("HISTORY ::: Recieve message {}", message);
//    }
}

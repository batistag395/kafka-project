package com.example.str_producer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StringProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessage(String message){
        kafkaTemplate.send("str-topic", message)
                .whenComplete((result, e)-> {
                    if(e != null){
                        log.info("Mensagem não enviada: {}", e.getMessage());
                    }else{
                        log.info("Mensagem enviada com sucesso: {}", result.getProducerRecord());
                        log.info("Partition: {}, OffSet: {}",
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });
    }
}

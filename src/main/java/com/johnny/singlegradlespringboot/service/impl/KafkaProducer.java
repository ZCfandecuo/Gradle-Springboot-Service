package com.johnny.singlegradlespringboot.service.impl;/*
package com.johnny.studyredis.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {
    public static final String TOPIC = "first-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Producing messages:{}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
*/

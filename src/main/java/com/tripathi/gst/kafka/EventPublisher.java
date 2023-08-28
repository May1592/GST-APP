package com.tripathi.gst.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class EventPublisher {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(EventPublisher.class);
    @Async
    public void publishMessage(String messageKey, String topic, Object message){
        ListenableFuture<SendResult<String,Object>> listenableFuture = kafkaTemplate.send(topic,messageKey,message);
        listenableFuture.addCallback(new KafkaSendCallback<>(){
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                LOGGER.info("Message sent success: key {} \n" +
                        "topic {} \n partition {} \n timestamp {} ", messageKey,result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),result.getRecordMetadata().timestamp());
            }

            @Override
            public void onFailure(KafkaProducerException ex) {
                LOGGER.info("Publish message failed: {} " ,ex.getFailedProducerRecord());
            }
        });

    }
}

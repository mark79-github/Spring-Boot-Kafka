package com.sirma.kafka.demo.service;

import com.sirma.kafka.demo.common.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafKaProducerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafKaProducerService.class);
  private final KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  public KafKaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void sendMessage(String message) {
    this.kafkaTemplate.send(AppConstants.TOPIC_NAME_TEST, message);
    LOGGER.info("Message sent -> {}", message);
  }
}

package com.sirma.kafka.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sirma.kafka.demo.common.AppConstants;
import com.sirma.kafka.demo.model.KafkaMessage;
import com.sirma.kafka.demo.utils.ValidationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;

@Service
public class KafKaConsumerService {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumerService.class);
  private final ValidationUtil validationUtil;
  private final ObjectMapper objectMapper;

  @Autowired
  public KafKaConsumerService(ValidationUtil validationUtil, ObjectMapper objectMapper) {
    this.validationUtil = validationUtil;
    this.objectMapper = objectMapper;
  }

  @KafkaListener(topics = AppConstants.TOPIC_NAME_TEST, groupId = AppConstants.GROUP_ID)
  public void consume(@Payload String message) {
    LOGGER.info("Message received -> {}", message);

    try {
      KafkaMessage kafkaMessage = objectMapper.readValue(message, KafkaMessage.class);
      if (this.validationUtil.isValid(kafkaMessage)) {
        LOGGER.info("Kafka message: {}", kafkaMessage);
      } else {
        this.validationUtil.getViolations(kafkaMessage).stream()
            .map(ConstraintViolation::getMessage)
            .forEach(LOGGER::error);
      }

    } catch (JsonProcessingException e) {
      LOGGER.error(e.getOriginalMessage());
    }
  }
}

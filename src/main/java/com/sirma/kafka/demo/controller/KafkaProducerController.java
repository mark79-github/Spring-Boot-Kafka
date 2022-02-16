package com.sirma.kafka.demo.controller;

import com.sirma.kafka.demo.service.KafKaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerController.class);
  private final KafKaProducerService producerService;

  @Autowired
  public KafkaProducerController(KafKaProducerService producerService) {
    this.producerService = producerService;
  }

  @PostMapping(value = "/publish")
  public ResponseEntity<Object> sendMessageToKafkaTopic(@RequestBody String message) {
    try {
      this.producerService.sendMessage(message);
      return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (Exception e) {
      LOGGER.error("JsonProcessingException : {}", e.getMessage());
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}

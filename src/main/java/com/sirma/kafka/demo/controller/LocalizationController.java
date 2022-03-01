package com.sirma.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping(value = "locale")
public class LocalizationController {

    private final MessageSource messageSource;

    @Autowired
    public LocalizationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public ResponseEntity<String> getLocale() {
        String message = messageSource.getMessage("task.status.READY", null, Locale.ENGLISH);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}

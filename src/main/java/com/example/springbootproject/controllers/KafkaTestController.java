package com.example.springbootproject.controllers;

import com.example.springbootproject.kafka.NotesKafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class KafkaTestController {
    private final NotesKafkaProducer notesKafkaProducer;

    @PostMapping("/send_note")
    public String sendNoteToKafka(@RequestParam String message) {
        notesKafkaProducer.sendMessage(message);
        return "Message sent to Kafka: " + message;
    }
}
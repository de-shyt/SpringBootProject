package com.example.springbootproject.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotesKafkaConsumer {
    @KafkaListener(topics = "notes", groupId = "notes-group")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

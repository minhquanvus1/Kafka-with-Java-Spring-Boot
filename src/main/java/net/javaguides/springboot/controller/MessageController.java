package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private KafkaProducer kafkaProducer;

    // dependency injection for kafkaProducer
    @Autowired
    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // create an API to let Producer consume this API --> get data from query parameter with key = "message" (@RequestParam), and stores this data in message variable as String

    // http://localhost:8081/api/v1/kafka/publish?message=hello world
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        // call sendMessage function of kafkaProducer
        kafkaProducer.sendMessage(message);
        // return a ok message from ResponseEntity
        return ResponseEntity.ok("message sent to the topic");

    }
}

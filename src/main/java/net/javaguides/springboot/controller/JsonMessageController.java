package net.javaguides.springboot.controller;

import net.javaguides.springboot.kafka.JsonKafkaProducer;
import net.javaguides.springboot.payload.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    // dependency injection with JsonKafkaProducer
    public JsonMessageController(JsonKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    // create a API with POST, to send the User object via request body (@RequestBody) to the Producer
    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok(" JSON message sent to kafka topic");

    }
}

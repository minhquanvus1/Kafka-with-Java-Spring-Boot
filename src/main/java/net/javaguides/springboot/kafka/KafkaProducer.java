package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    // LOGGER interface to log the message to the console
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    // use Kafka Template for KafkaProducer to send message to Topic. In this case, we want each message sent by Producer, will have key is String, and value is String
    private KafkaTemplate<String, String> kafkaTemplate;

    // dependency injection (by using Constructor) with kafkaTemplate
    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // create a void function for kafkaProducer to send message to Topic
    public void sendMessage(String message) {
        // LOGGER interface to log the message to the console
        LOGGER.info(String.format("Message sent %s", message));
        // kafkaTemplate to send the message to the Topic
        kafkaTemplate.send("javaguides", message);
    }
}

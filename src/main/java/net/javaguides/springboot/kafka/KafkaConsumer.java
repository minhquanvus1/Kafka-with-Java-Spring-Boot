package net.javaguides.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    // LOGGER interface to log the message to the console
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    @KafkaListener(topics = "javaguides", groupId = "myGroup") // use annotation: KafkaListener to let: Consumer subscribes to a Topic, and let it belong to a groupID of a group of Consumers
    public void consume(String message) {
        // LOGGER interface to log the received message to the console
        LOGGER.info(String.format("message received --> %s", message));
        // by default, Kafka Consumer will consume the data from beginning (including historical data before it subscribes to the Topic)
    }
}

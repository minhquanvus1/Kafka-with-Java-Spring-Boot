package net.javaguides.springboot.kafka;

import net.javaguides.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

    // LOGGER interface to log the message to the console
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);

    // use kafkaTemplate for Producer to send message to Topic. In this case, we want each message has: key is String, and value is of User object
    private KafkaTemplate<String, User> kafkaTemplate;

    // dependency injection with kafkaTemplate
    public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // create a void function for Producer to send message to Topic
    public void sendMessage(User data) {

        // LOGGER interface to log the message to the console. Because here, the message is of type User, so we can use the overriden toString() method in User class to print the User data to the console
        LOGGER.info(String.format("message sent --> %s", data.toString()));
        // create a Message of type User. In this message, we specify the payload (value/content of message), and header (Topic), and finally we build() the message
        Message<User> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC, "javaguides_json").build();

        // use kafkaTemplate to send the message to the Topic
        kafkaTemplate.send(message);
    }
}

package net.lavrov.produc.common.sdfds.controllers;

import lombok.AllArgsConstructor;
import net.lavrov.produc.common.sdfds.entyti.Mapp;
import net.lavrov.produc.common.sdfds.entyti.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class KataController {
    private KafkaTemplate kafkaTemplate;

    @PostMapping("/user")
    public void sendMessage(@RequestBody User user) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            Message<User> message = MessageBuilder
                    .withPayload(user)
                    .setHeader(KafkaHeaders.TOPIC, "microservice_presentation_user")
                    .build();
            kafkaTemplate.send(message);
        }
    }
    @PostMapping("/map")
    public void sendMessage(@RequestBody Mapp mapp) {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            Message<Mapp> message = MessageBuilder
                    .withPayload(mapp)
                    .setHeader(KafkaHeaders.TOPIC, "microservice_presentation_mapp")
                    .build();
            kafkaTemplate.send(message);
        }
    }

}

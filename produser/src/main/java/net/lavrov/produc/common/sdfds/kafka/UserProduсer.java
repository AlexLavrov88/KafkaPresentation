package net.lavrov.produc.common.sdfds.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lavrov.produc.common.sdfds.entyti.Mapp;
import net.lavrov.produc.common.sdfds.entyti.User;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;



@Component
@Slf4j
@AllArgsConstructor
public class UserProduсer {

    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        log.info(String.format("Сообщение отправлено в топик --> %s", user));
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "microservice_presentation_user").build();
        kafkaTemplate.send(message);
    }

    public void sendMessage(Mapp mapp) {
        log.info(String.format("Сообщение отправлено в топик --> %s", mapp));
        Message<Mapp> message = MessageBuilder
                .withPayload(mapp)
                .setHeader(KafkaHeaders.TOPIC, "microservice_presentation_mapp")
                .build();
        kafkaTemplate.send(message);
    }

    @Bean
    public void sendMessages() throws InterruptedException {
        User user = new User(1, "Alex", "Lavrov", 20);
        sendMessage(user);
        Mapp mapp = new Mapp();
        Map<String, User> stringUserMap = new HashMap<>();
        stringUserMap.put("One", user);
        mapp.setUserMap(stringUserMap);
        sendMessage(mapp);

    }
}

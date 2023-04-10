package net.lavrov.produc.common.sdfds.kafka;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lavrov.produc.common.sdfds.entyti.Mapp;
import net.lavrov.produc.common.sdfds.entyti.User;
import org.springframework.boot.ApplicationRunner;
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
        Message<User> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "microservice_presentation").build();
        kafkaTemplate.send(message);

    }

    public void sendMessage(Mapp mapp) {
        log.info(String.format("Сообщение отправлено в топик --> %s", mapp));
        Message<Mapp> message = MessageBuilder
                .withPayload(mapp)
                .setHeader(KafkaHeaders.TOPIC, "microservice_presentation")
                .build();
        kafkaTemplate.send(message);

    }

    @Bean
    public ApplicationRunner runner() throws InterruptedException {
        Mapp mapp = new Mapp();
        String a = "One";
        User user = new User(1, "aaaa", "bbbb", 17);
        Map<String, User> stringUserMap = new HashMap<>();
        stringUserMap.put(a, user);
        mapp.setUserMap(stringUserMap);
        return args -> sendMessage(mapp);
    }


//    public void run(ApplicationArguments args) throws Exception {
//        int id = 0;
//        int age = 10;
//        while (id <= 5) {
//            sendMessage(new User(++id, "Alex", "Lavrov", age++));
//            TimeUnit.SECONDS.sleep(2);
//        }
//
//    }
}

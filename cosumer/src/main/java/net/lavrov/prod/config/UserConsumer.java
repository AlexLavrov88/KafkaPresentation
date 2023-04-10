package net.lavrov.prod.config;

import lombok.extern.slf4j.Slf4j;
import net.lavrov.prod.entyti.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserConsumer {

    @KafkaListener(topics = "microservice_presentation", groupId = "Kata")
    public void sendConsume (User user) {
        log.info(String.format("Получено новый изер и кафки ---> %s", user.toString()));
        User user1;
        user1 = user;
        System.out.println("Присвоение нового значения пользователю ---> %s"+ user1.toString());

    }

}

package net.lavrov.prod.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lavrov.prod.service.UserAndMapImpl;
import net.lavrov.produc.common.sdfds.entyti.Mapp;
import net.lavrov.produc.common.sdfds.entyti.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserConsumer {
    UserAndMapImpl userAndMap;

    @KafkaListener(topics = "microservice_presentation_user", groupId = "Kata")
    public void sendConsume(User user) {
        log.info(String.format("Получено новый пользователь из кафки ---> %s", user.toString()));
        userAndMap.NotDuplicateUser(user);
        log.info(String.format("Пользователь  -  > %s", user));

    }

    @KafkaListener(topics = "microservice_presentation_mapp", groupId = "Kata")
    public void sendConsume1(Mapp mapp) {
        log.info(String.format("Получено новая MAP  из кафки ---> %s", mapp.toString()));
        String name = userAndMap.GetKeyMap(mapp);
        log.info(String.format("Имя файла  -> %s " , name));
    }
}

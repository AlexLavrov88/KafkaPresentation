package net.lavrov.prod.service;

import lombok.extern.slf4j.Slf4j;
import net.lavrov.produc.common.sdfds.entyti.Mapp;
import net.lavrov.produc.common.sdfds.entyti.User;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class UserAndMapImpl {
    private int count = 0;

    public void NotDuplicateUser(User user) {
        if (user.getId() > count) {
            log.info("Id пользователя не повторяется");
            count++;
        } else {
            log.info(String.format("Пользователь с ID = %s уже существует !", user.getId()));
        }
    }

    public String GetKeyMap(Mapp mapp) {
        String key = null;
        for (Map.Entry<String, User> map : mapp.getUserMap().entrySet()
        ) {
            key = map.getKey();
        }
        return key;
    }

}

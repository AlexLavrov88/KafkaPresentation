package net.lavrov.prod.entyti;

import lombok.*;

import java.util.Map;



@Data
@ToString
public class Mapp {
   private Map<String, User> userMap;

    public Mapp(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Mapp() {
    }

}

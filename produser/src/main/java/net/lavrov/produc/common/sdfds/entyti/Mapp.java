package net.lavrov.produc.common.sdfds.entyti;

import java.util.Map;

public class Mapp {
   private Map<String, User> userMap;

    public Mapp(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Mapp() {
    }

    public Map<String, User> getUserMap() {
        return this.userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public String toString() {
        return "Mapp(userMap=" + this.getUserMap() + ")";
    }
}

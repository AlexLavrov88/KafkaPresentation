package net.lavrov.produc.common.sdfds.entyti;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Mapp {
   private Map<String, User> userMap;
}

package net.lavrov.produc.common.sdfds.configur;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    public NewTopic topic() {
        return TopicBuilder.name("microservice_presentation_user")
                //.partitions(3)
                .build();
    }
    public NewTopic topic1() {
        return TopicBuilder.name("microservice_presentation_mapp")
                //.partitions(3)
                .build();
    }
}

package mq.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Setter
@Getter
@ConfigurationProperties(prefix = "mq")
public class ConnectionConfigProperties {

    private String connectionType;
    private String hostName;
    private int port;
    private String queueManager;
    private String channel;
    private String userName;
    private String queue;

}

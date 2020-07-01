package mq.client;

import mq.client.config.ConnectionConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@EnableConfigurationProperties(value = {ConnectionConfigProperties.class})
@SpringBootApplication
public class MqWebClientAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqWebClientAppApplication.class, args);
	}

}

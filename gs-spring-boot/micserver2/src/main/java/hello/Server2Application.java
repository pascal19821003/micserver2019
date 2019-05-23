package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Server2Application {
    Logger logger = LoggerFactory.getLogger(Server2Application.class);

    public static void main(String[] args) {
        //new SpringApplicationBuilder(Application.class).web(true).run(args);
        SpringApplication.run(Server2Application.class, args);
    }
}

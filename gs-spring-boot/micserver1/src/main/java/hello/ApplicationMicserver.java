package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
@RequestMapping("/ts")
public class ApplicationMicserver{
    Logger logger = LoggerFactory.getLogger(ApplicationMicserver.class);

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/t1")
    public String t1() {
        logger.info("test................................");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/t", String.class);
        return "Micserver t1  " + forEntity.getBody().toString();
    }
    @RequestMapping("/t2")
    public String t2() {
        logger.info("test................................");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8080/t", String.class);
        return "Micserver t2  " + forEntity.getBody().toString();
    }


    public static void main(String[] args) {
        //new SpringApplicationBuilder(Application.class).web(true).run(args);
        SpringApplication.run(ApplicationMicserver.class, args);
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }



}

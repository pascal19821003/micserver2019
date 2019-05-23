package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/s1")
public class Server1Controller {

    Logger logger = LoggerFactory.getLogger(Server1Controller.class);

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private HelloClient helloClient;

    @RequestMapping("/t1")
    public String t1() {
        logger.info("test................................");
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:8082/s2/t", String.class);
//        return "Micserver t1  " + forEntity.getBody().toString();
        String hello = helloClient.hello();
        return "Micserver t1  " + hello + " port: ";
    }

    @RequestMapping("/t2")
    public String t2() {
        logger.info("test................................");
        String hello = helloClient.hello();
        return "Micserver t2  " + hello;
    }

    @RequestMapping("/port")
    public String port(){
        return "server2:" + helloClient.getPort();
    }
}

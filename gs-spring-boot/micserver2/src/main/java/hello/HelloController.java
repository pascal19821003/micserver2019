package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/s2")
public class HelloController {

    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Value("${server.port}")
    private Integer port;

    @RequestMapping("/")
    public String home() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String hello() {
        logger.info("test................................");
        return "Hello world";
    }

    @RequestMapping("/getPort")
    public Integer getPort(){
        return port;
    }
}

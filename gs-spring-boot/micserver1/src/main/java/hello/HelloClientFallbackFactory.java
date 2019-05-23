package hello;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class HelloClientFallbackFactory implements FallbackFactory<HelloClient> {
    Logger logger = LoggerFactory.getLogger(HelloClientFallbackFactory.class);

    @Override
    public HelloClient create(Throwable throwable) {
        return new HelloClient(){

            @Override
            @RequestMapping("/s2/hello")
            public String hello() {
                logger.error(throwable.getMessage(), throwable);
                return "default hello";
            }

            @Override
            @RequestMapping("/s2/getPort")
            public Integer getPort() {
                logger.error(throwable.getMessage(), throwable);
                return 0;
            }
        };
    }
}

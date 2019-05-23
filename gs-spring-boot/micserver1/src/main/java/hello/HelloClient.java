package hello;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="MICSERVER2", fallbackFactory = HelloClientFallbackFactory.class)
@Component
public interface HelloClient {

    @RequestMapping("/s2/hello")
    public String hello();

    @RequestMapping("/s2/getPort")
    public Integer getPort();
}

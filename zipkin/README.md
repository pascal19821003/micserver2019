# Eureka Server Sample

Run this project as a Spring Boot app (e.g. import into IDE and run
main method, or use "mvn spring-boot:run or gradle bootRun or ./gradlew bootRun"). It will start up on port
8761 and serve the Eureka API from "/eureka".

## Resources

| Path             | Description  |
|------------------|--------------|
| /                        | Home page (HTML UI) listing service registrations          |
| /eureka/apps         | Raw registration metadata |

## Docker Container

There is a Maven goal (using a [plugin](https://github.com/spring-cloud-samples/eureka/blob/feature/docker/pom.xml#L48)) to 
generate the Docker container. The container is published in dockerhub at `springcloud/eureka`.


====================================================

https://cloud.spring.io/spring-cloud-netflix/

zuul: https://www.cnblogs.com/huangjuncong/p/9060984.html

micserver1: https://blog.csdn.net/zhangli_wei0403/article/details/84072015


sleuth: https://www.jianshu.com/p/5df2e83d0ef8
        https://spring.io/projects/spring-cloud-sleuth
        
参考的工程 ：  /home/pascal/IdeaProject/study/StudySpring/springcloud/microservice/springcloud-demo        
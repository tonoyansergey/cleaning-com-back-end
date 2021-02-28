package am.hay.cc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("am.hay.cc")
@ComponentScan(basePackages = "am.hay.cc")
@EnableMongoRepositories(basePackages = "am.hay.cc.repository")
public class CCApplication {

    public static void main(String[] args) {
        SpringApplication.run(CCApplication.class, args);
    }
}

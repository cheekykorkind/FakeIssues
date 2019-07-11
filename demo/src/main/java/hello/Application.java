package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.mybatis.spring.annotation.MapperScan;

import hello.Migration;

@SpringBootApplication
@MapperScan(basePackages = "hello")
public class Application  implements CommandLineRunner {

    @Autowired
    private Migration migration;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        migration.run();
    }
}
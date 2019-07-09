package hello;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.mybatis.spring.annotation.MapperScan;

import hello.UserMapper;
import hello.MemberSeeder;

@SpringBootApplication
@MapperScan(basePackages = "hello")
public class Application  implements CommandLineRunner {
    
	@Autowired
    private MemberSeeder MemberSeeder;

    @Autowired
    private UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        MemberSeeder.registerMember();
        System.out.println("inserted");

        System.out.println(userMapper.readUser("user3").getPassword());
    }
}
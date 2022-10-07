package com.av;

import com.av.db.User;
import com.av.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            User user = new User();
            user.setLogin("user");
            user.setPassword("user");
            userRepository.save(user);
        };
    }
}

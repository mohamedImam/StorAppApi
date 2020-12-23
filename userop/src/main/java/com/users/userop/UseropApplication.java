package com.users.userop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories (basePackages = {"com"})
@EntityScan(basePackages = {"com"})
@ComponentScan(basePackages = {"com"})
public class UseropApplication {

    public static void main(String[] args) {
        SpringApplication.run(UseropApplication.class, args);
    }

}

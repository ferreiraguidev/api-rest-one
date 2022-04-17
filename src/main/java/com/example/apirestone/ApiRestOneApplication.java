package com.example.apirestone;

import com.example.apirestone.service.UsersServices;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestOneApplication {

    private final UsersServices usersServices;

    public ApiRestOneApplication(UsersServices usersServices) {
        this.usersServices = usersServices;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiRestOneApplication.class, args);
    }
    @Bean
    InitializingBean sendDataUser() {
        return () -> {
            usersServices.createUserAdmin();
            usersServices.createUser();
        };
    }
}

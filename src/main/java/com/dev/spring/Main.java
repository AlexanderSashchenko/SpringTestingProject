package com.dev.spring;

import com.dev.spring.config.AppConfig;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        final UserService userService = context.getBean(UserService.class);

        User user = new User();
        user.setName("IvanIvanych");
        user.setAge(99);
        user.setFootSize(55.5);
        userService.add(user);

        userService.listUsers().forEach(System.out::println);
    }
}

package com.dev.spring.controller;

import com.dev.spring.dto.UserResponseDto;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable("id") Long id) {
        return getDto(userService.get(id));
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        return userService.listUsers().stream().map(this::getDto).collect(Collectors.toList());
    }

    @RequestMapping(value = "/inject", method = RequestMethod.GET)
    public String inject() {
        User user = new User();
        user.setName("Aldo_Apache");
        user.setAge(41);
        user.setFootSize(44D);
        userService.add(user);
        user.setName("Beatrix_Kiddo");
        user.setAge(34);
        user.setFootSize(37D);
        userService.add(user);
        user.setName("Mr_Orange");
        user.setAge(36);
        user.setFootSize(42.5);
        userService.add(user);
        user.setName("Django_Unchained");
        user.setAge(33);
        user.setFootSize(46D);
        userService.add(user);
        return "- Vincent, are we happy? - Yeah, we happy!";
    }

    private UserResponseDto getDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setFootsize(user.getFootSize());
        return userResponseDto;
    }
}

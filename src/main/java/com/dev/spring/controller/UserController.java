package com.dev.spring.controller;

import com.dev.spring.dto.UserResponseDto;
import com.dev.spring.model.User;
import com.dev.spring.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable("id") Long id) {
        UserResponseDto userResponseDto = new UserResponseDto();
        User user = userService.get(id);
        userResponseDto.setName(user.getName());
        userResponseDto.setAge(user.getAge());
        userResponseDto.setFootsize(user.getFootSize());
        return userResponseDto;
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (User user : userService.listUsers()) {
            UserResponseDto userResponseDto = new UserResponseDto();
            userResponseDto.setName(user.getName());
            userResponseDto.setAge(user.getAge());
            userResponseDto.setFootsize(user.getFootSize());
            userResponseDtoList.add(userResponseDto);
        }
        return userResponseDtoList;
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
}

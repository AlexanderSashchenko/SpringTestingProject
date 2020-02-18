package com.dev.spring.dto;

public class UserResponseDto {
    private String name;
    private Integer age;
    private Double footsize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getFootsize() {
        return footsize;
    }

    public void setFootsize(Double footsize) {
        this.footsize = footsize;
    }
}

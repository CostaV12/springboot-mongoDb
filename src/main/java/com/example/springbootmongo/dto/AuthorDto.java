package com.example.springbootmongo.dto;

import com.example.springbootmongo.domain.User;

import java.io.Serializable;

public class AuthorDto implements Serializable {

    private String id;
    private String name;

    public AuthorDto() {}

    public AuthorDto(User user) {
        id = user.getId();
        name = user.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

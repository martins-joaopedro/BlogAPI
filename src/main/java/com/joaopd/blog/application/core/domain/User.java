package com.joaopd.blog.application.core.domain;

import com.joaopd.blog.application.core.dto.UserDTO;

public class User {

    String id;
    String image;
    String name;

    public User(String id, String image, String name) {
        this.id = id;
        this.image = image;
        this.name = name;
    }

    public User(UserDTO dto) {
        this.name = dto.name();
        this.image = dto.image();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

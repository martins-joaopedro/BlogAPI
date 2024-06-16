package com.joaopd.blog.adapter.in.entities;

import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.dto.UserDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String id;

    String name;

    String image;

    public UserEntity(UserDTO dto) {
        this.name = dto.name();
        this.image = dto.image();
    }

    public UserEntity() {}

    public User toUser() {
        return new User(id, name, image);
    }
}

package com.joaopd.blog.adapter.in.entities;

import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.dto.UserDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PostEntity> posts;

    public UserEntity(UserDTO dto) {
        this.name = dto.name();
        this.image = dto.image();
    }

    public UserEntity() {}

    public User toUser() {
        return new User(id, name, image);
    }
}

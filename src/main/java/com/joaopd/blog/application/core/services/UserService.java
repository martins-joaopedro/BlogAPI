package com.joaopd.blog.application.core.services;

import com.joaopd.blog.adapter.in.entities.UserEntity;
import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.dto.UserDTO;
import com.joaopd.blog.application.ports.in.UserServicePort;
import com.joaopd.blog.application.ports.out.UserRepositoryPort;

public class UserService implements UserServicePort {

    private final UserRepositoryPort repository;

    public UserService(UserRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public void createUser(UserDTO dto) {
        this.repository.create(new UserEntity(dto));
    }

    @Override
    public User findUserById(String id) {
        return this.repository.findUserById(id);
    }
}

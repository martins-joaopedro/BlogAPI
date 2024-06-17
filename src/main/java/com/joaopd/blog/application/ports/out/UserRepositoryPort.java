package com.joaopd.blog.application.ports.out;

import com.joaopd.blog.adapter.in.entities.UserEntity;
import com.joaopd.blog.application.core.domain.User;

public interface UserRepositoryPort {

    void create(UserEntity entity);

    User findUserById(String id);
}

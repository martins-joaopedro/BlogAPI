package com.joaopd.blog.adapter.out;

import com.joaopd.blog.adapter.in.entities.UserEntity;
import com.joaopd.blog.adapter.out.repositories.UserSpringRepository;
import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.ports.out.UserRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepository implements UserRepositoryPort {

    private final UserSpringRepository repository;

    UserRepository(UserSpringRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(UserEntity entity) {
        this.repository.save(entity);
    }

    @Override
    public User findUserById(String id) {

        Optional<UserEntity> user = this.repository.findById(id);

        System.out.println(user + id);

        if(user.isPresent())
            return user.get().toUser();
        else return null;
    }
}

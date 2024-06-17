package com.joaopd.blog.adapter.out.repositories;

import com.joaopd.blog.adapter.in.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSpringRepository extends JpaRepository<UserEntity, String> {}

package com.joaopd.blog.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaopd.blog.adapter.in.entities.PostEntity;

@Repository
public interface PostSpringRepository extends JpaRepository<PostEntity, String> {}

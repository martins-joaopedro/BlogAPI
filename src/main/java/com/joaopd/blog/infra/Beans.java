package com.joaopd.blog.infra;

import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.services.UserService;
import com.joaopd.blog.application.ports.in.UserServicePort;
import com.joaopd.blog.application.ports.out.UserRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joaopd.blog.application.core.services.PostService;
import com.joaopd.blog.application.ports.in.PostServicePort;
import com.joaopd.blog.application.ports.out.PostRepositoryPort;

@Configuration
public class Beans {
    
    @Bean
    PostServicePort postService(PostRepositoryPort postRepository) {
        return new PostService(postRepository);
    }

    @Bean
    UserServicePort userService(UserRepositoryPort userRepository) {
        return new UserService(userRepository);
    }
}

package com.joaopd.blog.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joaopd.blog.application.core.services.PostService;
import com.joaopd.blog.application.ports.in.PostServicePort;
import com.joaopd.blog.application.ports.out.PostRepositoryPort;

@Configuration
public class Beans {
    
    @Bean
    PostServicePort postService(PostRepositoryPort postRepositoryPort) {
        return new PostService(postRepositoryPort);
    }
}

package com.joaopd.blog.application.ports.in;

import com.joaopd.blog.application.core.domain.User;
import com.joaopd.blog.application.core.dto.UserDTO;

public interface UserServicePort {

    void createUser(UserDTO dto);

    User findUserById(String id);
}

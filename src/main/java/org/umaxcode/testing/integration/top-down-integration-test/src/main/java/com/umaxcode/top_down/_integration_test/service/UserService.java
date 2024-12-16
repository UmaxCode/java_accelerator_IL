package com.umaxcode.top_down._integration_test.service;

import com.umaxcode.top_down._integration_test.domain.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);
}

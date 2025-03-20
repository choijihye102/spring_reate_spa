package com.example.jennie.semiprojectv2.service;

import com.example.jennie.semiprojectv2.domain.User;

public interface UserService {

    User newUser(User user);

    User loginUser(User user);

}
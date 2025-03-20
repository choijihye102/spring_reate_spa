package com.example.jennie.semiprojectv2.service;

import com.example.jennie.semiprojectv2.domain.User;
import com.example.jennie.semiprojectv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User newUser(User user) {
        // 아이디 중복 체크
        if (userRepository.existsByUserid(user.getUserid())) {
            throw new IllegalStateException("Service에서 호출 => 이미 존재하는 아이디입니다 ");
        }

        // 이메일 중복 체크
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("Service에서 호출 => 이미 존재하는 이메일입니다 ");
        }

        return userRepository.save(user);
    }

    @Override
    public User loginUser(User user) {
        return null;
    }
}

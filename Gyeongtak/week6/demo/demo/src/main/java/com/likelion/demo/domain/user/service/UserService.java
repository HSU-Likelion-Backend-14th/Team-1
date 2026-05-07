package com.likelion.demo.domain.user.service;

import com.likelion.demo.domain.user.entitiy.User;
import com.likelion.demo.domain.user.reporsitory.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}

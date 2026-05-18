package com.likelion.demo.domain.user.service;

import com.likelion.demo.domain.user.entity.User;
import com.likelion.demo.domain.user.exception.UserAlreadyExistExeption;
import com.likelion.demo.domain.user.repository.UserRepository;
import com.likelion.demo.domain.user.web.dto.UserSaveReq;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(UserSaveReq req){
        userRepository.findByUsername(req.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistExeption();
                });

        User user = User.builder()
                .username(req.getUsername())
                .gender(req.getGender())
                .build();

        userRepository.save(user);
    }
}

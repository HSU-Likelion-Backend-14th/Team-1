package com.likelion.demo.domain.user.reporsitory;

import com.likelion.demo.domain.user.entitiy.User;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(@NotBlank(message = "이름은 필수입니다.") String username);
}

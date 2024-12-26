package com.umaxcode.springboot_security_oauth_actuator.repository;

import com.umaxcode.springboot_security_oauth_actuator.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String username);
}

package com.umaxcode.bottom_up_integration_test.repository;

import com.umaxcode.bottom_up_integration_test.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}

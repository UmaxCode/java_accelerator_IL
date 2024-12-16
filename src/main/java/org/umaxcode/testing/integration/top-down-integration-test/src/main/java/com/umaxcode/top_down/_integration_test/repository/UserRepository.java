package com.umaxcode.top_down._integration_test.repository;

import com.umaxcode.top_down._integration_test.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

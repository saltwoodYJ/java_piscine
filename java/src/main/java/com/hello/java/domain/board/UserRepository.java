package com.hello.java.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserRepository extends JpaRepository<User, Long> {
}
package com.debxrshi.collabcode.repository;

import com.debxrshi.collabcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}

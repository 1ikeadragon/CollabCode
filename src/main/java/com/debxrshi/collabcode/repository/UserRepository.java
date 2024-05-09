package com.debxrshi.collabcode.repository;

import com.debxrshi.collabcode.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByIdAndUser(Long id, String user);
    boolean findByIdAndUser(Long id, String user);

    boolean findByUserAndPasword(String user, String password);
}

package com.nsure.repository;

import com.nsure.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmail(String email);
}

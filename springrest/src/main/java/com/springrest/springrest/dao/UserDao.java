package com.springrest.springrest.dao;

import com.springrest.springrest.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}

package com.jsp.jpa.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.jpa.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
 public List<User> findByName(String name);
}

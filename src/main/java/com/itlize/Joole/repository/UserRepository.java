package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByName(String name);

    List<User> findById(int id);

}

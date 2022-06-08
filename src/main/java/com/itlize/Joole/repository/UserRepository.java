package com.itlize.Joole.repository;


import com.itlize.Joole.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //user name is unique
    Optional<User> findByName(String name);
}

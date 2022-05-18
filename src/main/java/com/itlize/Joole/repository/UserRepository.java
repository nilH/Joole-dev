package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Project;
import com.itlize.Joole.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Override
    <S extends User> S save(S entity);
}

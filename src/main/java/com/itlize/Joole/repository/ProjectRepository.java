package com.itlize.Joole.repository;

import com.itlize.Joole.entity.Project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {



    Project findByproject_id(int id);

}

package ems.example.ems_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ems.example.ems_demo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}

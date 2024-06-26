package ems.example.ems_demo.repository;

import org.springframework.stereotype.Repository;

import ems.example.ems_demo.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}

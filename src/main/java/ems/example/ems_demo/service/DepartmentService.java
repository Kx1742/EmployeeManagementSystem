package ems.example.ems_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.example.ems_demo.model.Department;
import ems.example.ems_demo.repository.DepartmentRepository;

@Service
public class DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    //fetch all departments
    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    //fetch department by id
    public Optional<Department> getDepartmentById(Long id){
        return departmentRepository.findById(id);
    }

    //add department
    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    //update department
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }

    //delete department
    public String deleteDepartment(Long id){
        departmentRepository.deleteById(id);
        return "Department removed "+id;
    }
}

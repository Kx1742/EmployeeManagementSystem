package ems.example.ems_demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ems.example.ems_demo.exception.DepartmentNotFoundException;
import ems.example.ems_demo.model.Department;
import ems.example.ems_demo.service.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

 

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        if (department.isEmpty()) {
            throw new DepartmentNotFoundException("Department not found with id: " + id);
        }
        return department;
    }
    
    @PostMapping("/")
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
        Department department = departmentService.getDepartmentById(id)
                                                .orElseThrow(() -> new IllegalArgumentException("Department not found with id " + id));
        department.setName(departmentDetails.getName());
        return departmentService.updateDepartment(department);
    }
    
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
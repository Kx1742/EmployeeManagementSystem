package ems.example.ems_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import ems.example.ems_demo.model.Employee;
import ems.example.ems_demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
    @Autowired //inject dependencies
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //fetch all employees
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //fetch employee by id
    @Cacheable(value = "employeeCache", key = "#id")
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
    

    //add employee
    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //update employee
    @CacheEvict(value = "employeeCache", key = "#employee.id", beforeInvocation = true)
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //delete employee
    @CacheEvict(value = "employeeCache", key = "#id")
    public String deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return "Employee removed " + id;
    }
}
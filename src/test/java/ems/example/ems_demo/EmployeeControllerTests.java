package ems.example.ems_demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import ems.example.ems_demo.controller.EmployeeController;
import ems.example.ems_demo.model.Department;
import ems.example.ems_demo.model.Employee;
import ems.example.ems_demo.service.DepartmentService;
import ems.example.ems_demo.service.EmployeeService;

@WebMvcTest(EmployeeController.class)
@AutoConfigureMockMvc
public class EmployeeControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    @WithMockUser(username = "admin", roles = { "USER" })
    public void testGetEmployeeById() throws Exception {
        // Mock data
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John Doe");

        // Mock service method
        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(employee));

        // Perform GET request and verify response
        mockMvc.perform(get("/api/employees/{id}", 1L))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("John Doe"));
    }

    //fail with 403 unauthorized
    @Test
    @WithMockUser(username = "admin", roles = { "USER" })
    public void testAddEmployee() throws Exception {
        // Mock data
        Employee employee = new Employee();
        employee.setName("Jane Smith");
        employee.setPosition("Development");
    
        // Mock service method
        when(employeeService.addEmployee(any(Employee.class))).thenReturn(employee);
    
        // Perform POST request and verify response
        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Jane Smith\", \"position\": \"Development\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Jane Smith"))
               .andExpect(jsonPath("$.position").value("Development"));
    }
    
    
}

package ems.example.ems_demo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import ems.example.ems_demo.repository.EmployeeRepository;
import ems.example.ems_demo.service.EmployeeService;
import ems.example.ems_demo.model.Employee;

@SpringBootTest
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee(); // Assuming Employee class exists
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee result = employeeService.addEmployee(employee);
        assertEquals(employee, result);
    }

    @Test
    public void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> result = employeeService.getAllEmployees();
        assertEquals(employees, result);
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = new Employee(); // Assuming Employee class exists
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        Optional<Employee> result = employeeService.getEmployeeById(1L);
        assertTrue(result.isPresent());
        assertEquals(employee, result.get());
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee(); // Assuming Employee class exists
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee result = employeeService.updateEmployee(employee);
        assertEquals(employee, result);
    }

    @Test
    public void testDeleteEmployee() {
        Long employeeId = 1L;
        doNothing().when(employeeRepository).deleteById(employeeId);
        String result = employeeService.deleteEmployee(employeeId);
        verify(employeeRepository, times(1)).deleteById(employeeId);
        assertEquals("Employee removed " + employeeId, result);
    }
}

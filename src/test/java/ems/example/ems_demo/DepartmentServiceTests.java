package ems.example.ems_demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import ems.example.ems_demo.model.Department;
import ems.example.ems_demo.repository.DepartmentRepository;
import ems.example.ems_demo.service.DepartmentService;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

   @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testGetAllDepartments() {
        // Mock data
        Department department1 = new Department();
        department1.setId(1L);
        department1.setName("HR");

        Department department2 = new Department();
        department2.setId(2L);
        department2.setName("Engineering");

        List<Department> departments = Arrays.asList(department1, department2);

        // Mock repository behavior
        when(departmentRepository.findAll()).thenReturn(departments);

        // Call service method
        List<Department> result = departmentService.getAllDepartments();

        // Assertions
        assertEquals(2, result.size());
        assertEquals("HR", result.get(0).getName());
        assertEquals("Engineering", result.get(1).getName());
    }

    @Test
    public void testGetDepartmentById() {
        // Mock data
        Department department = new Department();
        department.setId(1L);
        department.setName("HR");

        // Mock repository behavior
        when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));

        // Call service method
        Optional<Department> result = departmentService.getDepartmentById(1L);

        // Assertions
        assertTrue(result.isPresent());
        assertEquals("HR", result.get().getName());
    }

    @Test
    public void testAddDepartment() {
        // Mock data
        Department department = new Department();
        department.setName("HR");

        // Mock repository behavior
        when(departmentRepository.save(department)).thenReturn(department);

        // Call service method
        Department savedDepartment = departmentService.addDepartment(department);

        // Assertions
        assertNotNull(savedDepartment);
        assertEquals("HR", savedDepartment.getName());
    }

 
    @Test
    public void testDeleteDepartment() {

        // Mock repository behavior
        doNothing().when(departmentRepository).deleteById(1L);

        // Call service method
        String result = departmentService.deleteDepartment(1L);

        // Assertions
        assertEquals("Department removed 1", result);
    }


    
    @Test
    public void testUpdateDepartment() {
        // Prepare test data
        Department existingDepartment = new Department();
        existingDepartment.setId(1L);
        existingDepartment.setName("IT");

        Department updatedDepartment = new Department();
        updatedDepartment.setId(1L);
        updatedDepartment.setName("Human Resources");

        // Stub repository behavior
        when(departmentRepository.save(any(Department.class))).thenReturn(updatedDepartment);

        // Call service method
        Department result = departmentService.updateDepartment(updatedDepartment);

        // Assertions
        assertEquals("Human Resources", result.getName());

        // Verify interactions with the mocked repository
        verify(departmentRepository, times(1)).save(any(Department.class));
    }
}

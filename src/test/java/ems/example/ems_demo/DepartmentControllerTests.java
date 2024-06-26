package ems.example.ems_demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import ems.example.ems_demo.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private Department testDepartment;

    @BeforeEach
    public void setup() throws Exception {
        // Create a department to be used in tests
        Department department = new Department();
        department.setName("IT");
        String response = mockMvc.perform(post("/departments/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(department)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        testDepartment = objectMapper.readValue(response, Department.class);
    }

    @Test
    public void testGetAllDepartments() throws Exception {
        mockMvc.perform(get("/departments/"))
               .andExpect(status().isOk());
    }

    @Test
    public void testGetDepartmentById() throws Exception {
        mockMvc.perform(get("/departments/" + testDepartment.getId()))
               .andExpect(status().isOk());
    }

    @Test
    public void testUpdateDepartment() throws Exception {
        Department updatedDepartment = new Department();
        updatedDepartment.setName("HR");

        mockMvc.perform(put("/departments/" + testDepartment.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedDepartment)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteDepartment() throws Exception {
        mockMvc.perform(delete("/departments/" + testDepartment.getId()))
               .andExpect(status().isOk());
    }
}

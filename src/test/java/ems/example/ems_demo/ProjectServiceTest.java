package ems.example.ems_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import ems.example.ems_demo.model.Project;
import ems.example.ems_demo.repository.ProjectRepository;
import ems.example.ems_demo.service.ProjectService;

@SpringBootTest
public class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @Test
    public void testGetAllProjects() {
        Project project1 = new Project(); // Assume Project has a no-arg constructor
        Project project2 = new Project();
        List<Project> expectedProjects = Arrays.asList(project1, project2);

        when(projectRepository.findAll()).thenReturn(expectedProjects);

        List<Project> actualProjects = projectService.getAllProjects();

        verify(projectRepository, times(1)).findAll();
        assertEquals(expectedProjects, actualProjects);
    }

    @Test
    public void testGetProjectById() {
        Long projectId = 1L;
        Optional<Project> expectedProject = Optional.of(new Project());
        when(projectRepository.findById(projectId)).thenReturn(expectedProject);

        Optional<Project> actualProject = projectService.getProjectById(projectId);

        verify(projectRepository, times(1)).findById(projectId);
        assertEquals(expectedProject, actualProject);
    }

    @Test
    public void testAddProject() {
        Project project = new Project();
        when(projectRepository.save(project)).thenReturn(project);

        Project savedProject = projectService.addProject(project);

        verify(projectRepository, times(1)).save(project);
        assertEquals(project, savedProject);
    }

    @Test
    public void testUpdateProject() {
        Project project = new Project();
        when(projectRepository.save(project)).thenReturn(project);

        Project updatedProject = projectService.updateProject(project);

        verify(projectRepository, times(1)).save(project);
        assertEquals(project, updatedProject);
    }

    @Test
    public void testDeleteProject() {
        Long projectId = 1L;
        doNothing().when(projectRepository).deleteById(projectId);

        String message = projectService.deleteProject(projectId);

        verify(projectRepository, times(1)).deleteById(projectId);
        assertEquals("Project removed " + projectId, message);
    }
}
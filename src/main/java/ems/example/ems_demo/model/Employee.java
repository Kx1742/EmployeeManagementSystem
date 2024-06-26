package ems.example.ems_demo.model;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity      //table in db
public class Employee {
    //fields
    //id
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto generated pk
    private Long id; //employeeid
    
    //employee name
    @NotBlank(message = "Name is mandatory")
    @Pattern(regexp = "^[A-Za-z]+( [A-Za-z]+)*$", message = "Name must contain only letters and a single space between words")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    
    //employee position
    @NotNull(message = "Position cannot be null")
    private String position;

    //department
    @ManyToOne // *:1 department
    @JoinColumn(name="department_id") //fk in employee tb reference to department tb
    private Department department;


    //projects
    @ManyToMany //*:* project 
    @JoinTable(
        name="employee_project",
        joinColumns = @JoinColumn(name="employee_id"), //fk employee
        inverseJoinColumns = @JoinColumn(name="project_id") //fk project
    )
    private Set<Project> projects = new HashSet<>(); 

    public String getName(){
        return name;
    }

    public String getPosition(){
        return position;
    }

    public Department getDepartment(){
        return department;
    }

    public Set<Project> getProjects(){
        return projects;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setDepartment(Department department){
        this.department = department;
    }

    public void setProjects(Set<Project> projects){
        this.projects = projects;
    }

    public void setId(long l) {
        this.id=l;;
    }
}

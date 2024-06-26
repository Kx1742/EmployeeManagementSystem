package ems.example.ems_demo.model;

import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import java.util.Set;
import jakarta.persistence.Id;

@Entity
public class Project {
    //fields
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //project employees
    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public String getName() {
        return name;
    }

    public String setName(String name) {
        return this.name = name;
    }
}

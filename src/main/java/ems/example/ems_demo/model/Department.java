package ems.example.ems_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
@Entity
public class Department {
    //fields
    //id
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //department name
    private String name;

    //employee
    @OneToMany(mappedBy="department") //department in employee tb own relationship
    private Set<Employee> employees = new HashSet<>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(long l) {
        this.id=l;
    }

    public Long getId() {
        return id;
    }
}

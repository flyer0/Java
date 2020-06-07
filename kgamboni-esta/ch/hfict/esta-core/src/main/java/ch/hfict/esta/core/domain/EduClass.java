package ch.hfict.esta.core.domain;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class EduClass {
    @Id@GeneratedValue
    private Long id;
    private String name;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="educlass_id")
    private List<Student> students = new ArrayList<>();
    
    public EduClass() {}
    public EduClass(String name) {
        this.name = name;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public List<Student> getStudents(){
        return students;
    }
    
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
}

package ch.hfict.esta.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
    @Id@GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    @Temporal(TemporalType.DATE) // year-month-day only
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthdate;
    private Long educlass_id;
    
    public Student() {}
    
    public Student(String firstname, String lastname, Date birthdate, long educlass_id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.educlass_id = educlass_id;
    }
    

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public Long getEduclass_id() {
        return educlass_id;
    }
    public void setEduclass_id(Long educlass_id) {
        this.educlass_id = educlass_id;
    }

    
    
}

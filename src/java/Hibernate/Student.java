package Hibernate;
// Generated 13-Aug-2015 09:53:13 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Student generated by hbm2java
 */
@Entity
@Table(name="student"
    ,catalog="practicesql"
)
public class Student  implements java.io.Serializable {


     private int studentId;
     private String firstName;
     private String lastName;
     private Date dob;
     private int year;
     private Set<Studentclasses> studentclasseses = new HashSet<Studentclasses>(0);

    public Student() {
    }

	
    public Student(int studentId, String firstName, String lastName, Date dob, int year) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.year = year;
    }
    public Student(int studentId, String firstName, String lastName, Date dob, int year, Set<Studentclasses> studentclasseses) {
       this.studentId = studentId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.dob = dob;
       this.year = year;
       this.studentclasseses = studentclasseses;
    }
   
     @Id 

    
    @Column(name="StudentID", unique=true, nullable=false)
    public int getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    
    @Column(name="FirstName", nullable=false, length=250)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="LastName", nullable=false, length=250)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="DOB", nullable=false, length=10)
    public Date getDob() {
        return this.dob;
    }
    
    public void setDob(Date dob) {
        this.dob = dob;
    }

    
    @Column(name="Year", nullable=false)
    public int getYear() {
        return this.year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="student")
    public Set<Studentclasses> getStudentclasseses() {
        return this.studentclasseses;
    }
    
    public void setStudentclasseses(Set<Studentclasses> studentclasseses) {
        this.studentclasseses = studentclasseses;
    }




}



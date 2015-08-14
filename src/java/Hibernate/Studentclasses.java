package Hibernate;
// Generated 13-Aug-2015 09:53:13 by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Studentclasses generated by hbm2java
 */
@Entity
@Table(name="studentclasses"
    ,catalog="practicesql"
)
public class Studentclasses  implements java.io.Serializable {


     private StudentclassesId id;
     private Classes classes;
     private Student student;

    public Studentclasses() {
    }

	
    public Studentclasses(StudentclassesId id) {
        this.id = id;
    }
    public Studentclasses(StudentclassesId id, Classes classes, Student student) {
       this.id = id;
       this.classes = classes;
       this.student = student;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="studentId", column=@Column(name="StudentId") ), 
        @AttributeOverride(name="classId", column=@Column(name="ClassId") ) } )
    public StudentclassesId getId() {
        return this.id;
    }
    
    public void setId(StudentclassesId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ClassId", insertable=false, updatable=false)
    public Classes getClasses() {
        return this.classes;
    }
    
    public void setClasses(Classes classes) {
        this.classes = classes;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="StudentId", insertable=false, updatable=false)
    public Student getStudent() {
        return this.student;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }




}


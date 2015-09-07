package Hibernate;
// Generated Sep 4, 2015 6:55:56 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classes generated by hbm2java
 */
@Entity
@Table(name="classes"
    ,catalog="practicesql"
)
public class Classes  implements java.io.Serializable {


     private Integer classId;
     private String className;
     private int credits;
     private int teacherId;
     private Set<Studentclasses> studentclasseses = new HashSet<Studentclasses>(0);
     private Set<Teacherclasses> teacherclasseses = new HashSet<Teacherclasses>(0);

    public Classes() {
    }

	
    public Classes(String className, int credits, int teacherId) {
        this.className = className;
        this.credits = credits;
        this.teacherId = teacherId;
    }
    public Classes(String className, int credits, int teacherId, Set<Studentclasses> studentclasseses, Set<Teacherclasses> teacherclasseses) {
       this.className = className;
       this.credits = credits;
       this.teacherId = teacherId;
       this.studentclasseses = studentclasseses;
       this.teacherclasseses = teacherclasseses;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ClassID", unique=true, nullable=false)
    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    
    @Column(name="ClassName", nullable=false, length=250)
    public String getClassName() {
        return this.className;
    }
    
    public void setClassName(String className) {
        this.className = className;
    }

    
    @Column(name="Credits", nullable=false)
    public int getCredits() {
        return this.credits;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }

    
    @Column(name="TeacherID", nullable=false)
    public int getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="classes")
    public Set<Studentclasses> getStudentclasseses() {
        return this.studentclasseses;
    }
    
    public void setStudentclasseses(Set<Studentclasses> studentclasseses) {
        this.studentclasseses = studentclasseses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="classes")
    public Set<Teacherclasses> getTeacherclasseses() {
        return this.teacherclasseses;
    }
    
    public void setTeacherclasseses(Set<Teacherclasses> teacherclasseses) {
        this.teacherclasseses = teacherclasseses;
    }




}



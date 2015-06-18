package Hibernate;
// Generated 18-Jun-2015 13:49:14 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
     private Teacher teacher;
     private String className;
     private int credits;
     private Set<Student> students = new HashSet<Student>(0);

    public Classes() {
    }

	
    public Classes(Teacher teacher, String className, int credits) {
        this.teacher = teacher;
        this.className = className;
        this.credits = credits;
    }
    public Classes(Teacher teacher, String className, int credits, Set<Student> students) {
       this.teacher = teacher;
       this.className = className;
       this.credits = credits;
       this.students = students;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ClassID", unique=true, nullable=false)
    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TeacherID", nullable=false)
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="classes")
    public Set<Student> getStudents() {
        return this.students;
    }
    
    public void setStudents(Set<Student> students) {
        this.students = students;
    }




}



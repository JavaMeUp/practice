package Hibernate;
// Generated Sep 4, 2015 6:55:56 PM by Hibernate Tools 4.3.1


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
 * Teacherclasses generated by hbm2java
 */
@Entity
@Table(name="teacherclasses"
    ,catalog="practicesql"
)
public class Teacherclasses  implements java.io.Serializable {


     private TeacherclassesId id;
     private Classes classes;
     private Teacher teacher;

    public Teacherclasses() {
    }

	
    public Teacherclasses(TeacherclassesId id) {
        this.id = id;
    }
    public Teacherclasses(TeacherclassesId id, Classes classes, Teacher teacher) {
       this.id = id;
       this.classes = classes;
       this.teacher = teacher;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="teacherId", column=@Column(name="TeacherId") ), 
        @AttributeOverride(name="classId", column=@Column(name="ClassId") ) } )
    public TeacherclassesId getId() {
        return this.id;
    }
    
    public void setId(TeacherclassesId id) {
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
    @JoinColumn(name="TeacherId", insertable=false, updatable=false)
    public Teacher getTeacher() {
        return this.teacher;
    }
    
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }




}



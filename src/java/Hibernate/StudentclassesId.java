package Hibernate;
// Generated Sep 4, 2015 6:55:56 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StudentclassesId generated by hbm2java
 */
@Embeddable
public class StudentclassesId  implements java.io.Serializable {


     private Integer studentId;
     private Integer classId;

    public StudentclassesId() {
    }

    public StudentclassesId(Integer studentId, Integer classId) {
       this.studentId = studentId;
       this.classId = classId;
    }
   


    @Column(name="StudentId")
    public Integer getStudentId() {
        return this.studentId;
    }
    
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }


    @Column(name="ClassId")
    public Integer getClassId() {
        return this.classId;
    }
    
    public void setClassId(Integer classId) {
        this.classId = classId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StudentclassesId) ) return false;
		 StudentclassesId castOther = ( StudentclassesId ) other; 
         
		 return ( (this.getStudentId()==castOther.getStudentId()) || ( this.getStudentId()!=null && castOther.getStudentId()!=null && this.getStudentId().equals(castOther.getStudentId()) ) )
 && ( (this.getClassId()==castOther.getClassId()) || ( this.getClassId()!=null && castOther.getClassId()!=null && this.getClassId().equals(castOther.getClassId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getStudentId() == null ? 0 : this.getStudentId().hashCode() );
         result = 37 * result + ( getClassId() == null ? 0 : this.getClassId().hashCode() );
         return result;
   }   


}



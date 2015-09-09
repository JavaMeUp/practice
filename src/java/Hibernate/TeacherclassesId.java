package Hibernate;
// Generated Sep 4, 2015 6:55:56 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TeacherclassesId generated by hbm2java
 */
@Embeddable
public class TeacherclassesId  implements java.io.Serializable {


     private Integer teacherId;
     private Integer classId;

    public TeacherclassesId() {
    }

    public TeacherclassesId(Integer teacherId, Integer classId) {
       this.teacherId = teacherId;
       this.classId = classId;
    }
   


    @Column(name="TeacherId")
    public Integer getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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
		 if ( !(other instanceof TeacherclassesId) ) return false;
		 TeacherclassesId castOther = ( TeacherclassesId ) other; 
         
		 return ( (this.getTeacherId()==castOther.getTeacherId()) || ( this.getTeacherId()!=null && castOther.getTeacherId()!=null && this.getTeacherId().equals(castOther.getTeacherId()) ) )
 && ( (this.getClassId()==castOther.getClassId()) || ( this.getClassId()!=null && castOther.getClassId()!=null && this.getClassId().equals(castOther.getClassId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getTeacherId() == null ? 0 : this.getTeacherId().hashCode() );
         result = 37 * result + ( getClassId() == null ? 0 : this.getClassId().hashCode() );
         return result;
   }   


}


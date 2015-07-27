package Hibernate;
// Generated 26-Jun-2015 08:25:17 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="practicesql"
    , uniqueConstraints = @UniqueConstraint(columnNames="userName") 
)
public class Users  implements java.io.Serializable {


     private Integer id;
     private String userName;
     private String userPassword;
     private boolean administer;
     private String StudentId;
     private String TeacherId;
     private Date LastLogined;

    public Users() {
    }

	
    public Users(String userPassword, boolean administer) {
        this.userPassword = userPassword;
        this.administer = administer;
    }
    public Users(String userName, String userPassword, boolean administer,String TeacherId, String StudentId) {
       this.userName = userName;
       this.userPassword = userPassword;
       this.administer = administer;
       this.StudentId=StudentId;
       this.TeacherId = TeacherId;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="userName", unique=true, length=252)
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    @Column(name="UserPassword", nullable=false, length=251)
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    
    @Column(name="Administer", nullable=false)
    public boolean isAdminister() {
        return this.administer;
    }
    
    public void setAdminister(boolean administer) {
        this.administer = administer;
    }

    @Column(name="TeacherId")
    public String getTeacherId ()
    {
        return this.TeacherId;
    }
    
    public void setTeacherId (String teacherId)
    {
        this.TeacherId = teacherId;
        
    }
    @Column(name="StudentId")
    public String getStudentId ()
    {
        return this.StudentId;
    }
    
    public void setStudentId (String studentId)
    {
        this.StudentId = studentId;
        
    }
   
    @Column(name="LastLogined")
    public Date getLastLogined ()
    {
        return this.LastLogined;
    }
    
    public void setLastLogined (Date LastLogined)
    {
        this.LastLogined = LastLogined;
        
    }


}



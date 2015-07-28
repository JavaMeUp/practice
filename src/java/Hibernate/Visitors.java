package Hibernate;
// Generated 26-Jun-2015 08:25:17 by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * Visitors generated by hbm2java
 */
@Entity
@Table(name="visitors"
    ,catalog="practicesql"
)
public class Visitors  implements java.io.Serializable {


     private Integer id;
     private String ipAddress;
     private String LoginName;
     private String PasswordSubmitted;
     private Date LastRequested;
     

    public Visitors() {
    }

    public Visitors(String ipAddress ,String LoginName , String PasswordSubmitted) 
    {
       this.ipAddress = ipAddress;
       this.LoginName = LoginName;
       this.PasswordSubmitted = PasswordSubmitted;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="ipAddress", nullable=false)
    public String getIpAddress() {
        return this.ipAddress;
    }
    
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
    
    @Column(name="LoginName")
    public String getLoginName()
    {
        return this.LoginName;
    }
    
    public void setLoginName(String loginName)
    {
        this.LoginName = loginName;
    }
    
    @Column(name="PasswordSubmitted")
    public String getPasswordSubmitted ()
    {
        return this.PasswordSubmitted;
    }
    
    public void setPasswordSubmitted (String passwordSubmitted)
    {
        this.PasswordSubmitted = passwordSubmitted;
    }

    @Column(name="LastRequested")
     @Temporal(javax.persistence.TemporalType.DATE)
    public Date getLastRequested ()
    {
        return this.LastRequested;
    }
    
    public void setLastRequested (Date LastRequested)
    {
        this.LastRequested = LastRequested;
    }


}



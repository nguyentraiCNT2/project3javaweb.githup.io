package project3.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "UserToken")
public class UserTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usertokenid")
    private Long usertokenid;
    @Column(name = "tokenurl")
    private String tokenurl;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userid;
    @Column(name = "datetoken")
    private Date datetoken;

    public Long getUsertokenid() {
        return usertokenid;
    }

    public void setUsertokenid(Long usertokenid) {
        this.usertokenid = usertokenid;
    }

    public String getTokenurl() {
        return tokenurl;
    }

    public void setTokenurl(String tokenurl) {
        this.tokenurl = tokenurl;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }

    public Date getDatetoken() {
        return datetoken;
    }

    public void setDatetoken(Date datetoken) {
        this.datetoken = datetoken;
    }
}

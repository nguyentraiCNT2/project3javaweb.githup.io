package project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserAddress")
public class UserAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressid")
    private Long addressid;
    @Column(name = "useraddress",columnDefinition = "NVARCHAR(MAX)")
    private String useraddress;
    @Column(name = "status")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "userid")
private UserEntity userid;
    public Long getAddressid() {
        return addressid;
    }

    public void setAddressid(Long addressid) {
        this.addressid = addressid;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }
}

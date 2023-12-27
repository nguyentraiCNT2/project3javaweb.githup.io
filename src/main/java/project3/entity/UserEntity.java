package project3.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @Column(name = "userid")
    private  String userid;//actions
    @Column(name = "username")
    private String username;//actions
    @Column(name = "password")
    private String password;
    @Column(name = "firtname",columnDefinition = "NVARCHAR(MAX)")
    private String firtname;
    @Column(name = "lastname",columnDefinition = "NVARCHAR(MAX)")
    private String lastname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;//actions
    @Column(name = "images")
    private String images;
    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEntity roleid;//actions

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirtname() {
        return firtname;
    }

    public void setFirtname(String firtname) {
        this.firtname = firtname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public RoleEntity getRoleid() {
        return roleid;
    }

    public void setRoleid(RoleEntity roleid) {
        this.roleid = roleid;
    }
}

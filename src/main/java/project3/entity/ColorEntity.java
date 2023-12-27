package project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "Colors")
public class ColorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "colorid")
    private Long colorid;
    @Column(name = "colorname")
    private String colorname;

    public Long getColorid() {
        return colorid;
    }

    public void setColorid(Long colorid) {
        this.colorid = colorid;
    }

    public String getColorname() {
        return colorname;
    }

    public void setColorname(String colorname) {
        this.colorname = colorname;
    }
}

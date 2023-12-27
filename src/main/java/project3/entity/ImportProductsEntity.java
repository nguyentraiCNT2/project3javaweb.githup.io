package project3.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ImportProducts")
public class ImportProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importproductsid")
    private Long importproductsid;
    @Column(name = "importproductsid")
    private Date importdate;

    public Long getImportproductsid() {
        return importproductsid;
    }

    public void setImportproductsid(Long importproductsid) {
        this.importproductsid = importproductsid;
    }

    public Date getImportdate() {
        return importdate;
    }

    public void setImportdate(Date importdate) {
        this.importdate = importdate;
    }
}

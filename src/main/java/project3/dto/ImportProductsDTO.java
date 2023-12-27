package project3.dto;

import javax.persistence.*;
import java.util.Date;

public class ImportProductsDTO {
    private Long importproductsid;
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

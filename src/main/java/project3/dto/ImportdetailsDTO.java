package project3.dto;

import project3.entity.ProductsEntity;

import javax.persistence.*;

public class ImportdetailsDTO {

    private Long importdetailsid;
    private Long productsid;
    private Long  importqty;
    private Long importProductsid;

    public Long getImportdetailsid() {
        return importdetailsid;
    }

    public void setImportdetailsid(Long importdetailsid) {
        this.importdetailsid = importdetailsid;
    }
    public Long getImportqty() {
        return importqty;
    }

    public void setImportqty(Long importqty) {
        this.importqty = importqty;
    }

    public Long getProductsid() {
        return productsid;
    }

    public void setProductsid(Long productsid) {
        this.productsid = productsid;
    }

    public Long getImportProductsid() {
        return importProductsid;
    }

    public void setImportProductsid(Long importProductsid) {
        this.importProductsid = importProductsid;
    }
}

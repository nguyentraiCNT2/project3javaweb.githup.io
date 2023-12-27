package project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "Importdetails")
public class ImportdetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "importdetailsid")
    private Long importdetailsid;
    @ManyToOne
    @JoinColumn(name = "productsid")
    private ProductsEntity productsid;
    @Column(name = "importdetailsid")
    private Long  importqty;
    @ManyToOne
    @JoinColumn(name = "importProductsid")
    private ImportProductsEntity importProductsid;

    public Long getImportdetailsid() {
        return importdetailsid;
    }

    public void setImportdetailsid(Long importdetailsid) {
        this.importdetailsid = importdetailsid;
    }

    public ProductsEntity getProductsid() {
        return productsid;
    }

    public void setProductsid(ProductsEntity productsid) {
        this.productsid = productsid;
    }

    public Long getImportqty() {
        return importqty;
    }

    public void setImportqty(Long importqty) {
        this.importqty = importqty;
    }

    public ImportProductsEntity getImportProductsid() {
        return importProductsid;
    }

    public void setImportProductsid(ImportProductsEntity importProductsid) {
        this.importProductsid = importProductsid;
    }
}

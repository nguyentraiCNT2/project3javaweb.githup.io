package project3.entity;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class ImagesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "imagesid")
    private Long imagesid;
    @Column(name = "imagesurl")
    private String imagesurl;
    @ManyToOne
    @JoinColumn(name = "productsid")
    private ProductsEntity productsid;

    public Long getImagesid() {
        return imagesid;
    }

    public void setImagesid(Long imagesid) {
        this.imagesid = imagesid;
    }

    public String getImagesurl() {
        return imagesurl;
    }

    public void setImagesurl(String imagesurl) {
        this.imagesurl = imagesurl;
    }

    public ProductsEntity getProductsid() {
        return productsid;
    }

    public void setProductsid(ProductsEntity productsid) {
        this.productsid = productsid;
    }
}

package project3.entity;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "Products")
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productsid")
    private Long productsid;
    @Column(name = "productcore")
    private String core;
    @Column(name = "productname",columnDefinition = "NVARCHAR(MAX)")
    private String productname;
    @Column(name = "productprice")
    private BigDecimal productprice;
    @Column(name = "productsdescribe",columnDefinition = "NVARCHAR(MAX)")
    private String productsdescribe;
    @Column(name = "productsview")
    private Long productsview;
    @Column(name = "productsqltk")
    private Long productsqltk;
    @Column(name = "productsqltk")
    private boolean productsstatus;
    @ManyToOne
    @JoinColumn(name = "colorid")
    private ColorEntity colorid;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private CategoryEntity categoryid;
    @ManyToOne
    @JoinColumn(name = "categoryLV2id")
    private CategoryLV2Entity categoryLV2id;
    @ManyToOne
    @JoinColumn(name = "loveListid")
    private LoveListEntity loveListid;

    public Long getProductsid() {
        return productsid;
    }

    public void setProductsid(Long productsid) {
        this.productsid = productsid;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public BigDecimal getProductprice() {
        return productprice;
    }

    public void setProductprice(BigDecimal productprice) {
        this.productprice = productprice;
    }

    public String getProductsdescribe() {
        return productsdescribe;
    }

    public void setProductsdescribe(String productsdescribe) {
        this.productsdescribe = productsdescribe;
    }

    public Long getProductsview() {
        return productsview;
    }

    public void setProductsview(Long productsview) {
        this.productsview = productsview;
    }

    public Long getProductsqltk() {
        return productsqltk;
    }

    public void setProductsqltk(Long productsqltk) {
        this.productsqltk = productsqltk;
    }

    public ColorEntity getColorid() {
        return colorid;
    }

    public void setColorid(ColorEntity colorid) {
        this.colorid = colorid;
    }

    public CategoryEntity getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(CategoryEntity categoryid) {
        this.categoryid = categoryid;
    }

    public CategoryLV2Entity getCategoryLV2id() {
        return categoryLV2id;
    }

    public void setCategoryLV2id(CategoryLV2Entity categoryLV2id) {
        this.categoryLV2id = categoryLV2id;
    }

    public LoveListEntity getLoveListid() {
        return loveListid;
    }

    public void setLoveListid(LoveListEntity loveListid) {
        this.loveListid = loveListid;
    }

    public boolean getProductsstatus() {
        return productsstatus;
    }

    public void setProductsstatus(boolean productsstatus) {
        this.productsstatus = productsstatus;
    }
}

package project3.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "ShoppingCart")
public class ShoppingCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cartid")
    private Long cartid;
    @ManyToOne
    @JoinColumn(name = "productsid")
    private ProductsEntity productsid;
    @Column(name = "dateadd")
    private Date dateadd;
    @Column(name = "qty")
    private Long qty;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userid;

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
    }

    public ProductsEntity getProductsid() {
        return productsid;
    }

    public void setProductsid(ProductsEntity productsid) {
        this.productsid = productsid;
    }

    public Date getDateadd() {
        return dateadd;
    }

    public void setDateadd(Date dateadd) {
        this.dateadd = dateadd;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }
}

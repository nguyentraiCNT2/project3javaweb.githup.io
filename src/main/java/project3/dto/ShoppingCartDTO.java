package project3.dto;

import java.util.Date;

public class ShoppingCartDTO {
    private Long cartid;
    private Long productsid;
    private Date dateadd;
    private Long qty;
    private String userid;

    public Long getCartid() {
        return cartid;
    }

    public void setCartid(Long cartid) {
        this.cartid = cartid;
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

    public Long getProductsid() {
        return productsid;
    }

    public void setProductsid(Long productsid) {
        this.productsid = productsid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

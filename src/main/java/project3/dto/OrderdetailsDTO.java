package project3.dto;

import java.math.BigDecimal;

public class OrderdetailsDTO {
    private Long orderdetailid;
    private Long orderid;
    private Long productsid;
    private Long totalamount;
    private BigDecimal unitprice;
    private Long shipid;

    public Long getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(Long orderdetailid) {
        this.orderdetailid = orderdetailid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }


    public Long getProductsid() {
        return productsid;
    }

    public void setProductsid(Long productsid) {
        this.productsid = productsid;
    }

    public Long getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Long totalamount) {
        this.totalamount = totalamount;
    }

    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    public Long getShipid() {
        return shipid;
    }

    public void setShipid(Long shipid) {
        this.shipid = shipid;
    }
}

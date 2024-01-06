package project3.entity;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "Orderdetails")
public class OrderdetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetailid")
    private Long orderdetailid;
    @ManyToOne
    @JoinColumn(name = "productsid")
    private ProductsEntity productsid;
    @Column(name = "totalamount")
    private Long totalamount;
    @Column(name = "unitprice")
    private BigDecimal unitprice;
    @ManyToOne
    @JoinColumn(name = "shipid")
    private ShipEntity shipid;
    @ManyToOne
    @JoinColumn(name = "orderid")
    private OrderEntity orderid;

    public Long getOrderdetailid() {
        return orderdetailid;
    }

    public void setOrderdetailid(Long orderdetailid) {
        this.orderdetailid = orderdetailid;
    }


    public ProductsEntity getProductsid() {
        return productsid;
    }

    public void setProductsid(ProductsEntity productsid) {
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

    public ShipEntity getShipid() {
        return shipid;
    }

    public void setShipid(ShipEntity shipid) {
        this.shipid = shipid;
    }

    public OrderEntity getOrderid() {
        return orderid;
    }

    public void setOrderid(OrderEntity orderid) {
        this.orderid = orderid;
    }
}

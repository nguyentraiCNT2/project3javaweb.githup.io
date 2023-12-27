package project3.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderid;
    @Column(name = "orderqty")
    private Long orderqty;
    @Column(name = "orderdate")
    private Date orderdate;
    @Column(name = "deliverydate")
    private Date deliverydate;
    @Column(name = "orderstatus",columnDefinition = "NVARCHAR(MAX)")
    private String orderstatus;
    @Column(name = "orderpay",columnDefinition = "NVARCHAR(MAX)")
    private String orderpay;
    @Column(name = "ordercancel",columnDefinition = "NVARCHAR(MAX)")
    private String ordercancel;
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userid;
    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(Long orderqty) {
        this.orderqty = orderqty;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Date getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(Date deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus;
    }

    public String getOrderpay() {
        return orderpay;
    }

    public void setOrderpay(String orderpay) {
        this.orderpay = orderpay;
    }

    public String getOrdercancel() {
        return ordercancel;
    }

    public void setOrdercancel(String ordercancel) {
        this.ordercancel = ordercancel;
    }

    public UserEntity getUserid() {
        return userid;
    }

    public void setUserid(UserEntity userid) {
        this.userid = userid;
    }
}

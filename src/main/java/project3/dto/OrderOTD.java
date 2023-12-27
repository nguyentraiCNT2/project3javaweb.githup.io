package project3.dto;

import java.util.Date;

public class OrderOTD {
    private Long orderid;
    private Long orderqty;
    private Date orderdate;
    private Date deliverydate;
    private String orderstatus;
    private String orderpay;
    private String ordercancel;
    private String userid;
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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}

package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.OrderOTD;
import project3.dto.OrderRequestDTO;
import project3.dto.OrderdetailsDTO;
import project3.entity.OrderEntity;
import project3.entity.OrderdetailsEntity;

import java.util.List;


public interface OrderService  {
    List<OrderOTD> getAll(Pageable pageable);
    int totalItem();
   OrderOTD findByOrderid(Long orderid);
    OrderRequestDTO getByOrderid(Long orderid);
    List<OrderOTD> getByOrderstatus(String orderstatus, Pageable pageable);
    List<OrderOTD> getByOrderpay(String orderpay, Pageable pageable);
    List<OrderOTD> getByOrdercancel(String ordercancel, Pageable pageable);
    List<OrderOTD> getByUserid(String userid, Pageable pageable);
    void placeOrder(OrderOTD order, List<OrderdetailsDTO> orderDetailsList);
    void approveOrders(OrderOTD order, List<OrderdetailsDTO> orderDetailsList);
    void deleteByOrderid(Long orderid);
    void createOrder(OrderOTD orderOTD);
    void updateOrder(OrderOTD orderOTD);
}

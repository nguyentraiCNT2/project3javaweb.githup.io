package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.OrderOTD;
import project3.dto.ShipDTO;
import project3.entity.OrderEntity;

import java.util.List;
import java.util.Optional;


public interface OrderService  {
    List<OrderOTD> getAll(Pageable pageable);
    int totalItem();
   OrderOTD findByOrderid(Long orderid);
    List<OrderOTD> getByUserid(String userid, Pageable pageable);
    void deleteByOrderid(Long orderid);
    void createOrder(OrderOTD orderOTD);
    void updateOrder(OrderOTD orderOTD);
}

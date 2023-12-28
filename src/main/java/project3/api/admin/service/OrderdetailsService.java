package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.OrderdetailsDTO;
import project3.dto.ShipDTO;
import project3.entity.OrderdetailsEntity;

import java.util.List;
import java.util.Optional;


public interface OrderdetailsService {
  List<OrderdetailsDTO> getAll(Pageable pageable);
  int totalItem();
  OrderdetailsDTO getByOrderdetailid(Long orderdetailid);
    List<OrderdetailsDTO> getByOrderid(Long orderid, Pageable pageable);
    List<OrderdetailsDTO> getByProductsid(Long productsid, Pageable pageable);
    List<OrderdetailsDTO> getByShipid(Long shipid, Pageable pageable);
    void deleteByOrderdetailid(Long orderdetailid);
    void createOrderdetails(OrderdetailsDTO orderdetailsDTO);
    void updateOrderdetails(OrderdetailsDTO orderdetailsDTO);
}

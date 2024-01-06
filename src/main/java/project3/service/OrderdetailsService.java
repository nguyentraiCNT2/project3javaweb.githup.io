package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.OrderOTD;
import project3.dto.OrderdetailsDTO;

import java.util.List;


public interface OrderdetailsService {
  List<OrderdetailsDTO> getAll(Pageable pageable);
  int totalItem();
  OrderdetailsDTO getByOrderdetailid(Long orderdetailid);

    List<OrderdetailsDTO> getByProductsid(Long productsid, Pageable pageable);
    List<OrderdetailsDTO> getByShipid(Long shipid, Pageable pageable);
  List<OrderdetailsDTO> getByOrderid(Long orderid, Pageable pageable);
    void deleteByOrderdetailid(Long orderdetailid);
    void createOrderdetails(OrderdetailsDTO orderdetailsDTO);
    void updateOrderdetails(OrderdetailsDTO orderdetailsDTO);
}

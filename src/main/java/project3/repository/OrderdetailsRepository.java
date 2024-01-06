package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.OrderdetailsDTO;
import project3.entity.OrderEntity;
import project3.entity.OrderdetailsEntity;
import project3.entity.ProductsEntity;
import project3.entity.ShipEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderdetailsRepository extends JpaRepository<OrderdetailsEntity, Long> {
    Optional<OrderdetailsEntity> findByOrderdetailid(Long orderdetailid);

    List<OrderdetailsEntity> findByProductsid(ProductsEntity products, Pageable pageable);
    List<OrderdetailsEntity> findByShipid(ShipEntity ship, Pageable pageable);
    List<OrderdetailsEntity> findByOrderid(OrderEntity order, Pageable pageable);
    List<OrderdetailsEntity> findByOrderid(OrderEntity order);
    void deleteByOrderdetailid(Long orderdetailid);
    OrderdetailsEntity saveAndFlush(OrderdetailsEntity orderdetailsEntity);
}

package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.OrderEntity;
import project3.entity.OrderdetailsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderdetailsRepository extends JpaRepository<OrderdetailsEntity, Long> {
    Optional<OrderdetailsEntity> findByOrderdetailid(Long orderdetailid);
    List<OrderdetailsEntity> findByUserid(String userid);
    List<OrderdetailsEntity> findByOrderid(Long orderid);
    List<OrderdetailsEntity> findByProductsid(Long productsid);
    List<OrderdetailsEntity> findByShipid(Long shipid);
    void deleteByOrderdetailid(Long orderdetailid);
    OrderdetailsEntity saveAndFlush(OrderdetailsEntity orderdetailsEntity);
}

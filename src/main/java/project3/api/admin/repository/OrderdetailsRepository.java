package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.OrderdetailsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderdetailsRepository extends JpaRepository<OrderdetailsEntity, Long> {
    Optional<OrderdetailsEntity> findByOrderdetailid(Long orderdetailid);
    List<OrderdetailsEntity> findByOrderid(Long orderid, Pageable pageable);
    List<OrderdetailsEntity> findByProductsid(Long productsid, Pageable pageable);
    List<OrderdetailsEntity> findByShipid(Long shipid, Pageable pageable);
    void deleteByOrderdetailid(Long orderdetailid);
    OrderdetailsEntity saveAndFlush(OrderdetailsEntity orderdetailsEntity);
}

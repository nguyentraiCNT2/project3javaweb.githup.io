package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.OrderEntity;
import project3.entity.OrderdetailsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByOrderid(Long orderid);
    List<OrderEntity> findByOrderstatus(String orderstatus, Pageable pageable);
    List<OrderEntity> findByOrderpay(String orderpay, Pageable pageable);
    List<OrderEntity> findByOrdercancel(String ordercancel, Pageable pageable);
    List<OrderEntity> findByUserid(String userid, Pageable pageable);
    void deleteByOrderid(Long orderid);
    OrderEntity saveAndFlush(OrderEntity orderEntity);
}

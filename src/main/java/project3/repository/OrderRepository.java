package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.OrderEntity;
import project3.entity.ReviewEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByOrderid(Long orderid);
    List<OrderEntity> findByUserid(String userid);
    void deleteByOrderid(Long orderid);
    OrderEntity saveAndFlush(OrderEntity orderEntity);
}

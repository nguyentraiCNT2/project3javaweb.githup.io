package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepositoryclient extends JpaRepository<OrderEntity,Long> {
    Optional<OrderEntity> findByOrderid(Long orderid);
    List<OrderEntity> findByUserid(String userid);
    void deleteByOrderid(Long orderid);
    OrderEntity saveAndFlush(OrderEntity orderEntity);
}

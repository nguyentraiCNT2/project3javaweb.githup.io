package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ShoppingCartEntity;
import project3.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity,Long> {
    Optional<ShoppingCartEntity> findByCartid(Long cartid);
    List<ShoppingCartEntity> findByProductsid(Long productsid);
    List<ShoppingCartEntity> findByUserid(String userid);
    void deleteByCartid(Long cartid);
    ShoppingCartEntity saveAndFlush(ShoppingCartEntity shoppingCartEntity);
}

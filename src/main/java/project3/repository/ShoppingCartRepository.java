package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ShoppingCartEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCartEntity,Long> {
    Optional<ShoppingCartEntity> findByCartid(Long cartid);
    List<ShoppingCartEntity> findByProductsid(Long productsid, Pageable pageable);
    List<ShoppingCartEntity> findByUserid(String userid, Pageable pageable);
    void deleteByCartid(Long cartid);
    ShoppingCartEntity saveAndFlush(ShoppingCartEntity shoppingCartEntity);
}

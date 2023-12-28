package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ProductsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    Optional<ProductsEntity> findByProductsid(Long productsid);
    List<ProductsEntity> findByCore(String core);
    List<ProductsEntity> findByProductname(String productname, Pageable pageable);
    List<ProductsEntity> findByProductprice(String productprice, Pageable pageable);
    List<ProductsEntity> findByProductsview(String productsview, Pageable pageable);
    List<ProductsEntity> findByCategoryLV2id(Long categoryLV2id, Pageable pageable);
    List<ProductsEntity> findByColorid(Long colorid, Pageable pageable);
    List<ProductsEntity> findByCategoryid(Long categoryid, Pageable pageable);
    List<ProductsEntity> findByLoveListid(Long loveListid, Pageable pageable);
    void deleteByProductsid(Long productsid);
    ProductsEntity saveAndFlush(ProductsEntity productsEntity);
}

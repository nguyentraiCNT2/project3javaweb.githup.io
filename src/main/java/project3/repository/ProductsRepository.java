package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ProductsEntity;
import project3.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity,Long> {
    Optional<ProductsEntity> findByAddressid(Long productsid);
    List<ProductsEntity> findByCore(String core);
    List<ProductsEntity> findByProductname(String productname);
    List<ProductsEntity> findByProductprice(String productprice);
    List<ProductsEntity> findByProductsview(String productsview);
    List<ProductsEntity> findByCategoryLV2id(Long categoryLV2id);
    List<ProductsEntity> findByColorid(Long colorid);
    List<ProductsEntity> findByCategoryid(Long categoryid);
    List<ProductsEntity> findByLoveListid(Long loveListid);
    void deleteByProductsid(Long productsid);
    ProductsEntity saveAndFlush(ProductsEntity productsEntity);
}

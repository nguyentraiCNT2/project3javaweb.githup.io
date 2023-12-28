package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ProductsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepositoryclient extends JpaRepository<ProductsEntity,Long> {
    Optional<ProductsEntity> findByProductsid(Long productsid);
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

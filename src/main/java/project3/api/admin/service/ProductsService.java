package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;
        import project3.dto.ProductsDTO;
        import project3.dto.ShipDTO;
        import project3.entity.ProductsEntity;

        import java.util.List;
        import java.util.Optional;
public interface ProductsService  {
    List<ProductsDTO> getAll(Pageable pageable);
    int totalItem();
    ProductsDTO getByProductsid(Long productsid);
    List<ProductsDTO> getByCore(String core);
    List<ProductsDTO> getByProductname(String productname, Pageable pageable);
    List<ProductsDTO> getByProductprice(String productprice, Pageable pageable);
    List<ProductsDTO> getByProductsview(String productsview, Pageable pageable);
    List<ProductsDTO> getByCategoryLV2id(Long categoryLV2id, Pageable pageable);
    List<ProductsDTO> getByColorid(Long colorid, Pageable pageable);
    List<ProductsDTO> getByCategoryid(Long categoryid, Pageable pageable);
    List<ProductsDTO> getByLoveListid(Long loveListid, Pageable pageable);
    void deleteByProductsid(Long productsid);
    void createProducts(ProductsDTO productsDTO);
    void updateProducts(ProductsDTO productsDTO);
}

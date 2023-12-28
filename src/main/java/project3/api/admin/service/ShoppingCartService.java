package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import project3.dto.ShoppingCartDTO;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCartDTO> getAll(Pageable pageable);
    int totalItem();
    ShoppingCartDTO getByCartid(Long cartid);
    List<ShoppingCartDTO> getByProductsid(Long productsid, Pageable pageable);
    List<ShoppingCartDTO> getByUserid(String userid, Pageable pageable);
    void deleteByCartid(Long cartid);
    void createShoppingCart(ShoppingCartDTO shoppingCartDTO);

    void updateShoppingCart(ShoppingCartDTO shoppingCartDTO);
}

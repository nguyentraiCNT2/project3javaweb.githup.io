package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ShoppingCartDTO;
import project3.entity.ShoppingCartEntity;

@Component
public class ShoppingCartMapper {
    private final ModelMapper modelMapper;

    public ShoppingCartMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ShoppingCartDTO maptoDTO (ShoppingCartEntity entity){
        ShoppingCartDTO dto = new ShoppingCartDTO();
        dto.setCartid(entity.getCartid());
        dto.setDateadd(entity.getDateadd());
        dto.setQty(entity.getQty());
        dto.setUserid(entity.getUserid().getUserid());
        dto.setProductsid(entity.getProductsid().getProductsid());
        return dto;
    }

    public ShoppingCartEntity maptoEntity (ShoppingCartDTO dto){
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setCartid(dto.getCartid());
        entity.setDateadd(dto.getDateadd());
        entity.setQty(dto.getQty());
        return entity;
    }
}

package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.OrderdetailsDTO;
import project3.entity.OrderdetailsEntity;

@Component
public class OrderdetailsMapper {
    private final ModelMapper modelMapper;
    public OrderdetailsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public OrderdetailsDTO maptoDTO (OrderdetailsEntity entity){
        OrderdetailsDTO dto = new OrderdetailsDTO();
        dto.setProductsid(entity.getProductsid() != null ? entity.getProductsid().getProductsid() : null);
        dto.setOrderdetailid(entity.getOrderdetailid());
        dto.setOrderid(entity.getOrderid() != null ? entity.getOrderid().getOrderid() : null);
    dto.setShipid(entity.getShipid() != null ?entity.getShipid().getShipid() : null);
        dto.setUnitprice(entity.getUnitprice());
        dto.setTotalamount(entity.getTotalamount());
        return dto;
    }
    public OrderdetailsEntity maptoEntity (OrderdetailsDTO dto){
        OrderdetailsEntity entity = new OrderdetailsEntity();
        entity.setOrderdetailid(dto.getOrderdetailid());
        entity.setUnitprice(dto.getUnitprice());
        entity.setTotalamount(dto.getTotalamount());
        return entity;
    }
}

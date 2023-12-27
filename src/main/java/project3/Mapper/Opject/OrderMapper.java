package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.OrderOTD;
import project3.dto.ProductsDTO;
import project3.entity.OrderEntity;
import project3.entity.ProductsEntity;

@Component
public class OrderMapper {
    private final ModelMapper modelMapper;

    public OrderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderOTD maptoDTO (OrderEntity entity){
        OrderOTD dto = new OrderOTD();
        dto.setOrderid(entity.getOrderid());
        dto.setUserid(entity.getUserid().getUserid());
        dto.setDeliverydate(entity.getDeliverydate());
        dto.setOrdercancel(entity.getOrdercancel());
        dto.setOrderdate(entity.getOrderdate());
        dto.setOrderstatus(entity.getOrderstatus());
        dto.setOrderpay(entity.getOrderpay());
        dto.setOrderqty(entity.getOrderqty());
        return dto;
    }
    public OrderEntity maptoEntity (OrderOTD dto){
        OrderEntity entity = new OrderEntity();
        entity.setOrderid(dto.getOrderid());
        entity.setDeliverydate(dto.getDeliverydate());
        entity.setOrdercancel(dto.getOrdercancel());
        entity.setOrderdate(dto.getOrderdate());
        entity.setOrderstatus(dto.getOrderstatus());
        entity.setOrderpay(dto.getOrderpay());
        entity.setOrderqty(dto.getOrderqty());
        return entity;
    }
}

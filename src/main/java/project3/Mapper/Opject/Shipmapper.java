package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ShipDTO;
import project3.dto.ShoppingCartDTO;
import project3.entity.ShipEntity;
import project3.entity.ShoppingCartEntity;
@Component
public class Shipmapper {
    private final ModelMapper modelMapper;

    public Shipmapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ShipDTO maptoDTO (ShipEntity entity){
        ShipDTO dto = new ShipDTO();
        dto.setShipid(entity.getShipid());
        dto.setShipdate(entity.getShipdate());
        dto.setStatus(entity.isStatus());
        dto.setShipname(entity.getShipname());
        dto.setShipprice(entity.getShipprice());
        return dto;
    }

    public ShipEntity maptoEntity (ShipDTO dto){
        ShipEntity entity = new ShipEntity();
        entity.setShipid(dto.getShipid());
        entity.setShipdate(dto.getShipdate());
        entity.setStatus(dto.isStatus());
        entity.setShipname(dto.getShipname());
        entity.setShipprice(dto.getShipprice());
        return entity;
    }
}

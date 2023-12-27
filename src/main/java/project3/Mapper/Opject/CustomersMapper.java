package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.CustomersDTO;
import project3.dto.ImagesDTO;
import project3.entity.CustomersEntity;
import project3.entity.ImagesEntity;

@Component
public class CustomersMapper {
    private final ModelMapper modelMapper;

    public CustomersMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CustomersDTO maptoDTO (CustomersEntity entity){
        CustomersDTO dto = new CustomersDTO();
        dto.setCustomerid(entity.getCustomerid());
        dto.setRoleid(entity.getRoleid().getRoleid());
        dto.setCustomername(entity.getCustomername());
        dto.setPassword(entity.getPassword());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setFirtname(entity.getFirtname());
        dto.setLastname(entity.getLastname());
        dto.setImages(entity.getImages());
        return dto;
    }
    public CustomersEntity maptoEntity (CustomersDTO dto){
        CustomersEntity entity = new CustomersEntity();
        entity.setCustomerid(dto.getCustomerid());
        entity.setCustomername(dto.getCustomername());
        entity.setPassword(dto.getPassword());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setFirtname(dto.getFirtname());
        entity.setLastname(dto.getLastname());
        entity.setImages(dto.getImages());
        return entity;
    }
}

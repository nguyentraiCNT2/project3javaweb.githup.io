package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.LoveListDTO;
import project3.dto.OrderdetailsDTO;
import project3.entity.LoveListEntity;
import project3.entity.OrderdetailsEntity;

@Component
public class LoveListMapper {
    private final ModelMapper modelMapper;

    public LoveListMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public LoveListDTO maptoDTO (LoveListEntity entity){
        LoveListDTO dto = new LoveListDTO();
        dto.setListdate(entity.getListdate());
        dto.setLovelistid(entity.getLovelistid());
        dto.setLovelistname(entity.getLovelistname());
        dto.setUserid(entity.getUserid().getUserid());
        return dto;
    }
    public LoveListEntity maptoEntity (LoveListDTO dto){
        LoveListEntity entity = new LoveListEntity();
        entity.setListdate(dto.getListdate());
        entity.setLovelistid(dto.getLovelistid());
        entity.setLovelistname(dto.getLovelistname());
        return entity;
    }
}

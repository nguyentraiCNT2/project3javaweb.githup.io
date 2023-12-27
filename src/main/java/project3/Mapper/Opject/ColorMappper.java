package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ColorDTO;
import project3.dto.LoveListDTO;
import project3.entity.ColorEntity;
import project3.entity.LoveListEntity;

@Component
public class ColorMappper {
    private final ModelMapper modelMapper;

    public ColorMappper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ColorDTO maptoDTO (ColorEntity entity){
        ColorDTO dto = new ColorDTO();
        dto.setColorid(entity.getColorid());
        dto.setColorname(entity.getColorname());
        return dto;
    }
    public ColorEntity maptoEntity (ColorDTO dto){
        ColorEntity entity = new ColorEntity();
        entity.setColorid(dto.getColorid());
        entity.setColorname(dto.getColorname());
        return entity;
    }
}

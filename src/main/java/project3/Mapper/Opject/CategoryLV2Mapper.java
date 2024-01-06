package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.CategoryLV2DTO;
import project3.entity.CategoryLV2Entity;

@Component
public class CategoryLV2Mapper {
    private final ModelMapper modelMapper;

    public CategoryLV2Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryLV2DTO maptoDTO (CategoryLV2Entity entity){
        CategoryLV2DTO dto = new CategoryLV2DTO();
        dto.setCategorylvid(entity.getCategorylvid());
        dto.setCategoryimageslogo(entity.getCategoryimageslogo());
        dto.setCategorylvname(entity.getCategorylvname());
        return dto;
    }
    public CategoryLV2Entity maptoEntity (CategoryLV2DTO dto){
        CategoryLV2Entity entity = new CategoryLV2Entity();
        entity.setCategorylvid(dto.getCategorylvid());
        entity.setCategoryimageslogo(dto.getCategoryimageslogo());
        entity.setCategorylvname(dto.getCategorylvname());
        return entity;
    }
}

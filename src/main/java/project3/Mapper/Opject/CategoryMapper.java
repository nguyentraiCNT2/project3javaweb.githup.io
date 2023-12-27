package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.CategoryDTO;
import project3.dto.CategoryLV2DTO;
import project3.entity.CategoryEntity;
import project3.entity.CategoryLV2Entity;


@Component
public class CategoryMapper {
    private final ModelMapper modelMapper;

    public CategoryMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CategoryDTO maptoDTO (CategoryEntity entity){
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryid(entity.getCategoryid());
        dto.setCategoryname(entity.getCategoryname());
        return dto;
    }
    public CategoryEntity maptoEntity (CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setCategoryid(dto.getCategoryid());
        entity.setCategoryname(dto.getCategoryname());
        return entity;
    }
}

package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ImagesDTO;
import project3.entity.ImagesEntity;

@Component
public class ImagesMapper {
    private final ModelMapper modelMapper;


    public ImagesMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImagesDTO maptoDTO (ImagesEntity entity){
        ImagesDTO dto = new ImagesDTO();
        dto.setProductsid(entity.getProductsid().getProductsid());
        dto.setImagesid(entity.getImagesid());
        dto.setImagesurl(entity.getImagesurl());
        return dto;
    }
    public ImagesEntity maptoEntity (ImagesDTO dto){
        ImagesEntity entity = new ImagesEntity();
        entity.setImagesid(dto.getImagesid());
        entity.setImagesurl(dto.getImagesurl());
        return entity;
    }
}

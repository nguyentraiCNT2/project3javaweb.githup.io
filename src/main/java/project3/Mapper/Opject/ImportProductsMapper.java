package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ImagesDTO;
import project3.dto.ImportProductsDTO;
import project3.entity.ImagesEntity;
import project3.entity.ImportProductsEntity;

@Component
public class ImportProductsMapper {
    private final ModelMapper modelMapper;


    public ImportProductsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImportProductsDTO maptoDTO (ImportProductsEntity entity){
        ImportProductsDTO dto = new ImportProductsDTO();
        dto.setImportproductsid(entity.getImportproductsid());
        dto.setImportdate(entity.getImportdate());
        return dto;
    }
    public ImportProductsEntity maptoEntity (ImportProductsDTO dto){
        ImportProductsEntity entity = new ImportProductsEntity();
        entity.setImportproductsid(dto.getImportproductsid());
        entity.setImportdate(dto.getImportdate());
        return entity;
    }
}

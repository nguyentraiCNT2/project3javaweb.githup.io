package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.ImportProductsDTO;
import project3.dto.ImportdetailsDTO;
import project3.entity.ImportProductsEntity;
import project3.entity.ImportdetailsEntity;

@Component
public class ImportdetailsMapper {
    private final ModelMapper modelMapper;


    public ImportdetailsMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImportdetailsDTO maptoDTO (ImportdetailsEntity entity){
        ImportdetailsDTO dto = new ImportdetailsDTO();
        dto.setImportdetailsid(entity.getImportdetailsid());
        dto.setImportqty(entity.getImportqty());
        dto.setImportProductsid(entity.getImportProductsid().getImportproductsid());
        dto.setProductsid(entity.getProductsid().getProductsid());
        return dto;
    }
    public ImportdetailsEntity maptoEntity (ImportdetailsDTO dto){
        ImportdetailsEntity entity = new ImportdetailsEntity();
        entity.setImportdetailsid(dto.getImportdetailsid());
        entity.setImportqty(dto.getImportqty());
        return entity;
    }
}

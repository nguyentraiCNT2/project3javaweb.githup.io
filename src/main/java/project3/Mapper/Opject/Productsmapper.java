package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import project3.dto.ProductsDTO;
import project3.dto.ReviewDTO;
import project3.entity.ProductsEntity;
import project3.entity.ReviewEntity;

public class Productsmapper {
    private final ModelMapper modelMapper;

    public Productsmapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductsDTO maptoDTO (ProductsEntity entity){
        ProductsDTO dto = new ProductsDTO();
        dto.setProductsid(entity.getProductsid());
        dto.setProductcore(entity.getCore());
        dto.setProductname(entity.getProductname());
        dto.setProductsview(entity.getProductsview());
        dto.setProductsqltk(entity.getProductsqltk());
        dto.setProductprice(entity.getProductprice());
        dto.setColorid(entity.getColorid().getColorid());
        dto.setCategoryid(entity.getCategoryid().getCategoryid());
        dto.setCategoryLV2id(entity.getCategoryLV2id().getCategorylvid());
        dto.setLoveListid(entity.getLoveListid().getLovelistid());
        return dto;
    }

    public ProductsEntity maptoEntity (ProductsDTO dto){
        ProductsEntity entity = new ProductsEntity();
        entity.setProductsid(dto.getProductsid());
        entity.setCore(dto.getProductcore());
        entity.setProductname(dto.getProductname());
        entity.setProductsview(dto.getProductsview());
        entity.setProductsqltk(dto.getProductsqltk());
        entity.setProductprice(dto.getProductprice());
        return entity;
    }
}

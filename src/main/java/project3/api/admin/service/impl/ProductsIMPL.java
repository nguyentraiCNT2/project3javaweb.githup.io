package project3.api.admin.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.Productsmapper;
import project3.api.admin.repository.*;
import project3.api.admin.service.ProductsService;
import project3.dto.ProductsDTO;
import project3.dto.ReviewDTO;
import project3.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsIMPL  implements ProductsService {
    @Autowired
    private final ProductsRepository productsRepository;
    private ModelMapper modelMapper;
    private Productsmapper productsmapper;
    private ColorRepository colorRepository;
    private CategoryLV2Repository categoryLV2Repository;
    private CategoryRepository categoryRepository;
    private LoveListRepository loveListRepository;

    public ProductsIMPL(ProductsRepository productsRepository, ModelMapper modelMapper, Productsmapper productsmapper, ColorRepository colorRepository, CategoryLV2Repository categoryLV2Repository, CategoryRepository categoryRepository, LoveListRepository loveListRepository) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.productsmapper = productsmapper;
        this.colorRepository = colorRepository;
        this.categoryLV2Repository = categoryLV2Repository;
        this.categoryRepository = categoryRepository;
        this.loveListRepository = loveListRepository;
    }


    @Override
    public List<ProductsDTO> getAll(Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findAll(pageable).getContent();
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) productsRepository.count();
    }

    @Override
    public ProductsDTO getByProductsid(Long productsid) {
        try {
                ProductsEntity products = productsRepository.findByProductsid(productsid)
                        .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + productsid));
                return productsmapper.maptoDTO(products);
            } catch (EntityNotFoundException ex) {
                throw ex;
            } catch (Exception e) {
                throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ProductsDTO> getByCore(String core) {
        try {
            List<ProductsEntity> products = productsRepository.findByCore(core);
            return products.stream()
                    .map(productsmapper::maptoDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ProductsDTO> getByProductname(String productname, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByProductname(productname,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByProductprice(String productprice, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByProductprice(productprice,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByProductsview(String productsview, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByProductsview(productsview,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByCategoryLV2id(Long categoryLV2id, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByCategoryLV2id(categoryLV2id,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByColorid(Long colorid, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByColorid(colorid,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByCategoryid(Long categoryid, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByCategoryid(categoryid,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ProductsDTO> getByLoveListid(Long loveListid, Pageable pageable) {
        List<ProductsDTO> results = new ArrayList<>();
        List<ProductsEntity> productsEntities = productsRepository.findByLoveListid(loveListid,pageable);
        for (ProductsEntity item: productsEntities
        ) {
            ProductsDTO DTO = productsmapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByProductsid(Long productsid) {
        productsRepository.deleteByProductsid(productsid);
    }

    @Override
    public void createProducts(ProductsDTO productsDTO) {
        if ( productsDTO != null) {
            ProductsEntity products = productsmapper.maptoEntity(productsDTO);
            CategoryEntity category = categoryRepository.findByCategoryid(productsDTO.getCategoryid()).orElse(null);
            CategoryLV2Entity categoryLV2 = categoryLV2Repository.findByCategorylvid(productsDTO.getCategoryLV2id()).orElse(null);
            ColorEntity color = colorRepository.findByColorid(productsDTO.getColorid()).orElse(null);
            LoveListEntity loveList = loveListRepository.findByLovelistid(productsDTO.getLoveListid()).orElse(null);
            if (products != null) {
                products.setCategoryid(category);
                products.setCategoryLV2id(categoryLV2);
                products.setColorid(color);
                products.setLoveListid(loveList);
                productsRepository.save(products);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateProducts(ProductsDTO productsDTO) {
        ProductsEntity existingProducts  = productsRepository.findByProductsid(productsDTO.getProductsid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(productsDTO, existingProducts);
        productsRepository.save(existingProducts);
    }
}

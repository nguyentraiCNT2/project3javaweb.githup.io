package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project3.service.ProductsService;
import project3.Mapper.Opject.Productsmapper;
import project3.repository.*;
import project3.dto.ProductsDTO;
import project3.entity.*;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductsIMPL  implements ProductsService {
    @Value("src/main/java/project3/Layout/AdminLayOut/admin/public/images/") // Đường dẫn để lưu ảnh, có thể đặt trong file properties/application.yml
    private String imageSavePath;
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
        CategoryLV2Entity categoryLV2 = categoryLV2Repository.findByCategorylvid(categoryLV2id).orElse(null);
        List<ProductsEntity> productsEntities = productsRepository.findByCategoryLV2id(categoryLV2,pageable);
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
        CategoryEntity categoryEntity = categoryRepository.findByCategoryid(colorid).orElse(null);
        ColorEntity color = colorRepository.findByColorid(colorid).orElse(null);
        List<ProductsEntity> productsEntities = productsRepository.findByColorid(color,pageable);
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
        CategoryEntity categoryEntity = categoryRepository.findByCategoryid(categoryid).orElse(null);
        List<ProductsEntity> productsEntities = productsRepository.findByCategoryid(categoryEntity,pageable);

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
        LoveListEntity loveList = loveListRepository.findByLovelistid(loveListid).orElse( null);
        List<ProductsEntity> productsEntities = productsRepository.findByLoveListid(loveList,pageable);
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
            List<ProductsEntity> productsEntityList = productsRepository.findByProductname(productsDTO.getProductname());
         if (productsEntityList.size() == 0){
             if (products != null) {
                 products.setCategoryid(category);
                 products.setCategoryLV2id(categoryLV2);
                 products.setColorid(color);
                 products.setLoveListid(loveList);
                 productsRepository.save(products);
             } else {
                 throw new RuntimeException("Không lấy được dữ liệu của Entity");
             }

         }else {
             for (ProductsEntity item :productsEntityList
             ) {
                 item.setProductsqltk(item.getProductsqltk() + productsDTO.getProductsqltk());
                 item.setProductprice(productsDTO.getProductprice());
                 productsRepository.save(item);
             }
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

    @Override
    public void uploadImage1(String productname, MultipartFile file) throws IOException {
       List<ProductsEntity>  products = productsRepository.findByProductname(productname);
        if (products != null) {
            for (ProductsEntity item: products
                 ) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = imageSavePath + filename;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                item.setImagesmain(filename);
                productsRepository.save(products);
            }
        }
    }
    @Override
    public void uploadImage2(String productname, MultipartFile file) throws IOException {
        List<ProductsEntity>  products = productsRepository.findByProductname(productname);
        if (products != null) {
            for (ProductsEntity item: products
            ) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = imageSavePath + filename;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                item.setImages2(filename);
                productsRepository.save(products);
            }
        }
    }
    @Override
    public void uploadImage3(String productname, MultipartFile file) throws IOException {
        List<ProductsEntity>  products = productsRepository.findByProductname(productname);
        if (products != null) {
            for (ProductsEntity item: products
            ) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = imageSavePath + filename;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                item.setImages3(filename);
                productsRepository.save(products);
            }
        }
    }
    @Override
    public void uploadImage4(String productname, MultipartFile file) throws IOException {
        List<ProductsEntity>  products = productsRepository.findByProductname(productname);
        if (products != null) {
            for (ProductsEntity item: products
            ) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = imageSavePath + filename;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                item.setImages4(filename);
                productsRepository.save(products);
            }
        }
    }
    @Override
    public void uploadImage5(String productname, MultipartFile file) throws IOException {
        List<ProductsEntity>  products = productsRepository.findByProductname(productname);
        if (products != null) {
            for (ProductsEntity item: products
            ) {
                String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                String filePath = imageSavePath + filename;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                item.setImages5(filename);
                productsRepository.save(products);
            }
        }
    }


}

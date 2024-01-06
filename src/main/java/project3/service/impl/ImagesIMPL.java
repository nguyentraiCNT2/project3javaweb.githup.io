package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import project3.service.ImagesService;
import project3.Mapper.Opject.ImagesMapper;
import project3.repository.ImagesRepository;
import project3.repository.ProductsRepository;
import project3.dto.ImagesDTO;
import project3.entity.*;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImagesIMPL implements ImagesService {
    @Value("src/main/java/project3/Layout/AdminLayOut/admin/public/images/") // Đường dẫn để lưu ảnh, có thể đặt trong file properties/application.yml
    private String imageSavePath;
    @Autowired
    private final ImagesRepository imagesRepository;
    private ModelMapper modelMapper;
    private ImagesMapper imagesMapper;
    private ProductsRepository productsRepository;


    public ImagesIMPL(ImagesRepository imagesRepository, ModelMapper modelMapper, ImagesMapper imagesMapper, ProductsRepository productsRepository) {
        this.imagesRepository = imagesRepository;
        this.modelMapper = modelMapper;
        this.imagesMapper = imagesMapper;
        this.productsRepository = productsRepository;
    }


    @Override
    public List<ImagesDTO> getAll(Pageable pageable) {
        List<ImagesDTO> results = new ArrayList<>();
        List<ImagesEntity> imagesEntities = imagesRepository.findAll(pageable).getContent();
        for (ImagesEntity item: imagesEntities
        ) {
            ImagesDTO DTO = imagesMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) imagesRepository.count();
    }

    @Override
    public ImagesDTO getByImagesid(Long imagesid) {
        try {
            ImagesEntity images = imagesRepository.findByImagesid(imagesid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + imagesid));
            return imagesMapper.maptoDTO(images);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ImagesDTO> getByProductsid(Long productsid, Pageable pageable) {
        List<ImagesDTO> results = new ArrayList<>();
        List<ImagesEntity> imagesEntities = imagesRepository.findByProductsid(productsid,pageable);
        for (ImagesEntity item: imagesEntities
        ) {
            ImagesDTO DTO = imagesMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ImagesDTO> getByImagesurl(String imagesurl, Pageable pageable) {
        List<ImagesDTO> results = new ArrayList<>();
        List<ImagesEntity> imagesEntities = imagesRepository.findByImagesurl(imagesurl,pageable);
        for (ImagesEntity item: imagesEntities
        ) {
            ImagesDTO DTO = imagesMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByImagesid(Long imagesid) {
        imagesRepository.deleteByImagesid(imagesid);
    }

    @Override
    public void createImages(ImagesDTO imagesDTO) {
        if ( imagesDTO != null) {
            ImagesEntity images = imagesMapper.maptoEntity(imagesDTO);
            ProductsEntity products = productsRepository.findByProductsid(imagesDTO.getProductsid()).orElse(null);
            if (images != null) {
                images.setProductsid(products);
                imagesRepository.save(images);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateImages(ImagesDTO imagesDTO) {
        ImagesEntity existingmages  = imagesRepository.findByImagesid(imagesDTO.getImagesid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(imagesDTO, existingmages);
        imagesRepository.save(existingmages);
    }

    @Override
    public void uploadImage(Long imagesid, MultipartFile file) throws IOException {
        ImagesEntity images = imagesRepository.findByImagesid(imagesid).orElse(null);
        if (images != null) {
            String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            String filePath = imageSavePath + filename;
            Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            images.setImagesurl(filename);
            imagesRepository.save(images);
        }
    }
}

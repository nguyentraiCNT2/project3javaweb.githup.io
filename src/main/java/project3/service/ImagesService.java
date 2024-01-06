package project3.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project3.dto.ImagesDTO;

import java.io.IOException;
import java.util.List;

public interface ImagesService {
    List<ImagesDTO> getAll(Pageable pageable);
    int totalItem();
    ImagesDTO getByImagesid(Long imagesid);
    List<ImagesDTO> getByProductsid(Long productsid, Pageable pageable);
    List<ImagesDTO> getByImagesurl(String imagesurl, Pageable pageable);
    void deleteByImagesid(Long imagesid);
    void createImages(ImagesDTO imagesDTO);
    void updateImages(ImagesDTO imagesDTO);
    void uploadImage(Long imagesid, MultipartFile file) throws IOException;
}

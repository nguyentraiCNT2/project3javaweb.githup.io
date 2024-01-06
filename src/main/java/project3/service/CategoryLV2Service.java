package project3.service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;
import project3.dto.CategoryLV2DTO;

import java.io.IOException;
import java.util.List;


public interface CategoryLV2Service {
    List<CategoryLV2DTO> getAll(Pageable pageable);
    int totalItem();
    CategoryLV2DTO findByCategorylvid(Long categorylvid);
    List<CategoryLV2DTO> findByCategorylvname(String categorylvname,Pageable pageable);
    void deleteByCategorylvid(Long categorylvid);
    void createCategorylvname(CategoryLV2DTO categoryLV2DTO);
    void updateCategorylvname(CategoryLV2DTO categoryLV2DTO);
    void uploadImage(Long categoryid, MultipartFile file) throws IOException;
}

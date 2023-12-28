package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.CategoryLV2DTO;
import project3.dto.ShipDTO;
import project3.entity.CategoryLV2Entity;

import java.util.List;
import java.util.Optional;


public interface CategoryLV2Service {
    List<CategoryLV2DTO> getAll(Pageable pageable);
    int totalItem();
    CategoryLV2DTO findByCategorylvid(Long categorylvid);
    List<CategoryLV2DTO> findByCategorylvname(String categorylvname);
    void deleteByCategorylvid(Long categorylvid);
    void createCategorylvname(CategoryLV2DTO categoryLV2DTO);
    void updateCategorylvname(CategoryLV2DTO categoryLV2DTO);
}

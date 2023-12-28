package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.CategoryDTO;
import project3.dto.ShipDTO;
import project3.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

public interface CategoryService{
    List<CategoryDTO> getAll(Pageable pageable);
    int totalItem();
   CategoryDTO getByCategoryid(Long categoryid);
    List<CategoryDTO> getByCategoryname(String categoryname);
    void deleteByCategoryid(Long categoryid);
    void createCategory(CategoryDTO categoryDTO);
    void updateCategory(CategoryDTO categoryDTO);
}

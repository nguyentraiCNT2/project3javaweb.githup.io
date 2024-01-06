package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.CategoryDTO;

import java.util.List;

public interface CategoryService{
    List<CategoryDTO> getAll(Pageable pageable);
    int totalItem();
   CategoryDTO getByCategoryid(Long categoryid);
    List<CategoryDTO> getByCategoryname(String categoryname,Pageable pageable);
    void deleteByCategoryid(Long categoryid);
    void createCategory(CategoryDTO categoryDTO);
    void updateCategory(CategoryDTO categoryDTO);

}

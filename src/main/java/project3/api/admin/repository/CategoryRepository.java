package project3.api.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByCategoryid(Long categoryid);
    List<CategoryEntity> findByCategoryname(String categoryname);
    void deleteByCategoryid(Long categoryid);
    CategoryEntity saveAndFlush(CategoryEntity categoryEntity);
}

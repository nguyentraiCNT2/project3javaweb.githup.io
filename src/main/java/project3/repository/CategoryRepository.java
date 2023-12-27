package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CategoryEntity;
import project3.entity.CategoryLV2Entity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByCategoryid(Long categoryid);
    List<CategoryEntity> findByCategorynamee(String categoryname);
    void deleteByCategoryid(Long categoryid);
    CategoryEntity saveAndFlush(CategoryEntity categoryEntity);
}

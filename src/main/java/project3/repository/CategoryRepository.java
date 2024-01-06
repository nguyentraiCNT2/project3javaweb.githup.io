package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByCategoryid(Long categoryid);
    List<CategoryEntity> findByCategoryname(String categoryname, Pageable pageable);
    void deleteByCategoryid(Long categoryid);
    CategoryEntity saveAndFlush(CategoryEntity categoryEntity);
}

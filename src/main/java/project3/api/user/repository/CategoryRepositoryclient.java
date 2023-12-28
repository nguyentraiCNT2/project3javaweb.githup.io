package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepositoryclient extends JpaRepository<CategoryEntity,Long> {
    Optional<CategoryEntity> findByCategoryid(Long categoryid);
    List<CategoryEntity> findByCategoryname(String categoryname);
    void deleteByCategoryid(Long categoryid);
    CategoryEntity saveAndFlush(CategoryEntity categoryEntity);
}

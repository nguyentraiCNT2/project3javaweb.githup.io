package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CategoryLV2Entity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryLV2Repository extends JpaRepository<CategoryLV2Entity,Long> {
    Optional<CategoryLV2Entity> findByCategorylvid(Long categorylvid);
    List<CategoryLV2Entity> findByCategorylvname(String categorylvname, Pageable pageable);
    void deleteByCategorylvid(Long categorylvid);
    CategoryLV2Entity saveAndFlush(CategoryLV2Entity categoryLV2Entity);
}

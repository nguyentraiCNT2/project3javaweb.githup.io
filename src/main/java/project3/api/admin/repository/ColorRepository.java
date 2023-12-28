package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ColorEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<ColorEntity,Long> {
    Optional<ColorEntity> findByColorid(Long colorid);
    List<ColorEntity> findByColorname(String colorname, Pageable pageable);
    void deleteByColorid(Long colorid);
    ColorEntity saveAndFlush(ColorEntity colorEntity);
}

package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ColorEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepositoryclient extends JpaRepository<ColorEntity,Long> {
    Optional<ColorEntity> findByColorid(Long colorid);
    List<ColorEntity> findByColorname(String colorname);
    void deleteByColorid(Long colorid);
    ColorEntity saveAndFlush(ColorEntity colorEntity);
}

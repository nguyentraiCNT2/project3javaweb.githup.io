package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ImagesEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagesRepository extends JpaRepository<ImagesEntity,Long> {
    Optional<ImagesEntity> findByImagesid(Long imagesid);
    List<ImagesEntity> findByProductsid(Long productsid, Pageable pageable);
    List<ImagesEntity> findByImagesurl(String imagesurl, Pageable pageable);
    void deleteByImagesid(Long imagesid);
    ImagesEntity saveAndFlush(ImagesEntity imagesEntity);
}

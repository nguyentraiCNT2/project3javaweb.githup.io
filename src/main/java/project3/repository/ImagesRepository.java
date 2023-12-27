package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ImagesEntity;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImagesRepository extends JpaRepository<ImagesEntity,Long> {
    Optional<ImagesEntity> findByImagesid(Long imagesid);
    List<ImagesEntity> findByProductsid(Long productsid);
    List<ImagesEntity> findByImagesurl(String imagesurl);
    void deleteByImagesid(Long imagesid);
    ImagesEntity saveAndFlush(ImagesEntity imagesEntity);
}

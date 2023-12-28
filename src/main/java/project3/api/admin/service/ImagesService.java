package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.ImagesDTO;
import project3.dto.ShipDTO;
import project3.entity.ImagesEntity;

import java.util.List;
import java.util.Optional;

public interface ImagesService {
    List<ImagesDTO> getAll(Pageable pageable);
    int totalItem();
    ImagesDTO getByImagesid(Long imagesid);
    List<ImagesDTO> getByProductsid(Long productsid, Pageable pageable);
    List<ImagesDTO> getByImagesurl(String imagesurl, Pageable pageable);
    void deleteByImagesid(Long imagesid);
    void createShip(ImagesDTO imagesDTO);
    void updateShip(ImagesDTO imagesDTO);
}

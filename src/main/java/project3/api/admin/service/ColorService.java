package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.ColorDTO;
import project3.dto.ShipDTO;
import project3.entity.ColorEntity;

import java.util.List;
import java.util.Optional;

public interface ColorService {
    List<ColorDTO> getAll(Pageable pageable);
    int totalItem();
 ColorDTO getByColorid(Long colorid);
    List<ColorDTO> getByColorname(String colorname, Pageable pageable);
    void deleteByColorid(Long colorid);
    void createShip(ColorDTO colorDTO);
    void updateShip(ColorDTO colorDTO);
}

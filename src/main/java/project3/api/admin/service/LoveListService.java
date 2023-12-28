package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.LoveListDTO;
import project3.dto.ShipDTO;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

public interface LoveListService{
  List<LoveListDTO> getAll(Pageable pageable);
  int totalItem();
  LoveListDTO getByLovelistid(Long lovelistid);
    List<LoveListDTO> getByUserid(String userid, Pageable pageable);
    List<LoveListDTO> getByLovelistname(String lovelistname, Pageable pageable);
    void deleteByLovelistid(Long lovelistid);
    void createLoveList(LoveListDTO shipDTO);
    void updateLoveList(LoveListDTO shipDTO);
}

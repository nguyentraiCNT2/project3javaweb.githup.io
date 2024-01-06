package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.LoveListDTO;

import java.util.List;

public interface LoveListService{
  List<LoveListDTO> getAll(Pageable pageable);
  int totalItem();
  LoveListDTO getByLovelistid(Long lovelistid);
    List<LoveListDTO> getByUserid(String userid, Pageable pageable);
    List<LoveListDTO> getByLovelistname(String lovelistname, Pageable pageable);
    void deleteByLovelistid(Long lovelistid);
    void createLoveList(LoveListDTO loveListDTO);
    void updateLoveList(LoveListDTO loveListDTO);
}

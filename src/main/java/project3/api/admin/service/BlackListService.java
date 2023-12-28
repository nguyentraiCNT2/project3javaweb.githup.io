package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.BlackListDTO;
import project3.dto.ShipDTO;
import project3.entity.BlackListEntity;

import java.util.List;
import java.util.Optional;

public interface BlackListService {
    List<BlackListDTO> getAll(Pageable pageable);
    int totalItem();
    BlackListDTO getByBalcklistid(Long balcklistid);
    List<BlackListDTO>getByBlacklistname(String blacklistname, Pageable pageable);
    List<BlackListDTO> getByUserid(String userid, Pageable pageable);
    void deleteByBalcklistid(Long balcklistid);
    void createBalcklist(ShipDTO shipDTO);
    void updateBalcklist(ShipDTO shipDTO);
}

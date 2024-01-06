package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.BlackListDTO;

import java.util.List;

public interface BlackListService {
    List<BlackListDTO> getAll(Pageable pageable);
    int totalItem();
    BlackListDTO getByBalcklistid(Long balcklistid);
    List<BlackListDTO>getByBlacklistname(String blacklistname, Pageable pageable);
    List<BlackListDTO> getByUserid(String userid, Pageable pageable);
    void deleteByBalcklistid(Long balcklistid);
    void createBalcklist(BlackListDTO blackListDTO);
    void updateBalcklist(BlackListDTO blackListDTO);
}

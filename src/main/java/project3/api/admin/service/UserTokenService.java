package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import project3.dto.UserDTO;
import project3.dto.UserTokenDTO;
import project3.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

public interface UserTokenService {
    List<UserTokenDTO> getAll(Pageable pageable);
    int totalItem();
    UserTokenDTO getByUsertokenid(Long usertokenid);
    List<UserTokenDTO> getByTokenurl(String tokenurl, Pageable pageable);
    List<UserTokenDTO> getByUserid(String userid, Pageable pageable);
    void deleteByUsertokenid(Long usertokenid);
    void createUserToken(UserTokenDTO userTokenDTO);

    void updateUserToken(UserTokenDTO userTokenDTO);
}

package project3.api.user.service;

import org.springframework.data.domain.Pageable;
import project3.dto.UserDTO;
import project3.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAll(Pageable pageable);
    int totalItem();
    UserDTO getByUserid(String userid);
    List<UserDTO> getByUsername(String username,Pageable pageable);
    List<UserDTO> getByEmail(String email);
    List<UserDTO> getByRoleid(Long roleid);
    void deleteByUserid(String userid);
    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

}

package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import project3.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll(Pageable pageable);
    int totalItem();
    UserDTO getByUserid(String userid);
    List<UserDTO> getByUsername(String username,Pageable pageable);
    List<UserDTO> getByEmail(String email);
    List<UserDTO> getByRoleid(Long roleid,Pageable pageable);
    void deleteByUserid(String userid);
    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

}

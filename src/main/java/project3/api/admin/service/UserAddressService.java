package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import project3.dto.UserAddressDTO;
import project3.dto.UserTokenDTO;
import project3.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

public interface UserAddressService {
    List<UserAddressDTO> getAll(Pageable pageable);
    int totalItem();
    UserAddressDTO getByUseraddressid(Long useraddressid);
    List<UserAddressDTO> getByUseraddress(String useraddress, Pageable pageable);
    List<UserAddressDTO> getByUserid(String userid, Pageable pageable);
    void deleteByUseraddressid(Long useraddressid);

    void createUserAddress(UserAddressDTO userAddressDTO);

    void updateUserAdress(UserAddressDTO userAddressDTO);
}

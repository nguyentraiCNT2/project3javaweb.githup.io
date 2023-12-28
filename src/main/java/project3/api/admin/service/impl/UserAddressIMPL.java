package project3.api.admin.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.UserAddressMapper;
import project3.api.admin.service.UserAddressService;
import project3.api.admin.repository.UserAddressRepository;
import project3.api.admin.repository.UserRepository;
import project3.dto.UserAddressDTO;
import project3.dto.UserDTO;
import project3.entity.RoleEntity;
import project3.entity.UserAddressEntity;
import project3.entity.UserEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserAddressIMPL implements UserAddressService {
    @Autowired
    private final UserAddressRepository userAddressRepository;
    private ModelMapper modelMapper;
    private UserAddressMapper userAddressMapper;
    private UserRepository userRepository;

    public UserAddressIMPL(UserAddressRepository userAddressRepository, ModelMapper modelMapper, UserAddressMapper userAddressMapper, UserRepository userRepository) {
        this.userAddressRepository = userAddressRepository;
        this.modelMapper = modelMapper;
        this.userAddressMapper = userAddressMapper;
        this.userRepository = userRepository;
    }


    @Override
    public List<UserAddressDTO> getAll(Pageable pageable) {
        List<UserAddressDTO> results = new ArrayList<>();
        List<UserAddressEntity> userAddressEntities = userAddressRepository.findAll(pageable).getContent();
        for (UserAddressEntity item: userAddressEntities
        ) {
            UserAddressDTO userAddressDTO = userAddressMapper.maptoDTO(item);
            results.add(userAddressDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserAddressDTO getByUseraddressid(Long useraddressid) {
        try {
            UserAddressEntity useraddress = userAddressRepository.findByUseraddressid(useraddressid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + useraddressid));
            return userAddressMapper.maptoDTO(useraddress);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserAddressDTO> getByUseraddress(String useraddress, Pageable pageable) {
        List<UserAddressDTO> results = new ArrayList<>();
        List<UserAddressEntity> userAddressEntities = userAddressRepository.findByUseraddress(useraddress,pageable);
        for (UserAddressEntity item: userAddressEntities
        ) {
            UserAddressDTO userAddressDTO = userAddressMapper.maptoDTO(item);
            results.add(userAddressDTO);
        }
        return results;
    }

    @Override
    public List<UserAddressDTO> getByUserid(String userid, Pageable pageable) {
        List<UserAddressDTO> results = new ArrayList<>();
        List<UserAddressEntity> userAddressEntities = userAddressRepository.findByUserid(userid,pageable);
        for (UserAddressEntity item: userAddressEntities
        ) {
            UserAddressDTO userAddressDTO = userAddressMapper.maptoDTO(item);
            results.add(userAddressDTO);
        }
        return results;
    }

    @Override
    public void deleteByUseraddressid(Long useraddressid) {
        userAddressRepository.deleteByUseraddressid(useraddressid);
    }

    @Override
    public void createUserAddress(UserAddressDTO userAddressDTO) {
        if ( userAddressDTO != null) {
            UserAddressEntity useraddress = userAddressMapper.maptoEntity(userAddressDTO);
            UserEntity user = userRepository.findByUserid(userAddressDTO.getUserid()).orElse(null);
            if (useraddress != null) {
                useraddress.setUserid(user);
                userAddressRepository.save(useraddress);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateUserAdress(UserAddressDTO userAddressDTO) {
        UserAddressEntity existingUserAddress  = userAddressRepository.findByUseraddressid(userAddressDTO.getAddressid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userAddressDTO, existingUserAddress);
        userAddressRepository.save(existingUserAddress);
    }
}

package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.UserMapper;
import project3.dto.UserDTO;
import project3.entity.RoleEntity;
import project3.entity.UserEntity;
import project3.repository.RoleRepository;
import project3.repository.UserRepository;
import project3.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private final UserRepository userRepository;
    private UserMapper userMapper;
    private ModelMapper modelMapper;
    private RoleRepository roleRepository;
    public UserIMPL(UserRepository userRepository, UserMapper userMapper, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<UserDTO> getAll(Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepository.findAll(pageable).getContent();
        for (UserEntity item: userEntities
        ) {
            UserDTO userDTO = userMapper.maptoDTO(item);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userRepository.count();
    }

    @Override
    public UserDTO getByUserid(String userid) {
        try {
            UserEntity user = userRepository.findByUserid(userid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userid));
            return userMapper.maptoDTO(user);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserDTO> getByUsername(String username) {
        try {
            List<UserEntity> user  = userRepository.findByUsername(username);
            return user.stream()
                    .map(userMapper::maptoDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserDTO> getByEmail(String email) {
        try {
            List<UserEntity> user  = userRepository.findByEmail(email);
            return user.stream()
                    .map(userMapper::maptoDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserDTO> getByRoleid(Long roleid) {
        return null;
    }

    @Override
    public void deleteByUserid(String userid) {
        userRepository.deleteByUserid(userid);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        if ( userDTO != null) {
            UserEntity user = userMapper.maptoEntity(userDTO);
            RoleEntity roleEntity = roleRepository.findByRoleid(userDTO.getRoleid()).orElse(null);
            if (user != null) {
                user.setRoleid(roleEntity);
                userRepository.save(user);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserEntity existingUser  = userRepository.findByUserid(userDTO.getUserid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userDTO, existingUser);
        userRepository.save(existingUser);
    }
}

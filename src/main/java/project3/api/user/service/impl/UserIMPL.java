package project3.api.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.UserMapper;
import project3.api.user.repository.RoleRepositoryclient;
import project3.api.user.service.UserService;
import project3.dto.UserDTO;
import project3.entity.RoleEntity;
import project3.entity.UserEntity;
import project3.api.user.repository.UserRepositoryclient;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserIMPL implements UserService {
    @Autowired
    private final UserRepositoryclient userRepositoryclient;
    private UserMapper userMapper;
    private ModelMapper modelMapper;
    private RoleRepositoryclient roleRepositoryclient;
    public UserIMPL(UserRepositoryclient userRepositoryclient, UserMapper userMapper, ModelMapper modelMapper, RoleRepositoryclient roleRepositoryclient) {
        this.userRepositoryclient = userRepositoryclient;
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
        this.roleRepositoryclient = roleRepositoryclient;
    }


    @Override
    public List<UserDTO> getAll(Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepositoryclient.findAll(pageable).getContent();
        for (UserEntity item: userEntities
        ) {
            UserDTO userDTO = userMapper.maptoDTO(item);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userRepositoryclient.count();
    }

    @Override
    public UserDTO getByUserid(String userid) {
        try {
            UserEntity user = userRepositoryclient.findByUserid(userid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userid));
            return userMapper.maptoDTO(user);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserDTO> getByUsername(String username,Pageable pageable) {
        List<UserDTO> results = new ArrayList<>();
        List<UserEntity> userEntities = userRepositoryclient.findByUsername(username,pageable);
        for (UserEntity item: userEntities
        ) {
            UserDTO userDTO = userMapper.maptoDTO(item);
            results.add(userDTO);
        }
        return results;
    }

    @Override
    public List<UserDTO> getByEmail(String email) {
        try {
            List<UserEntity> user  = userRepositoryclient.findByEmail(email);
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
        List<UserEntity> userEntities = userRepositoryclient.findByRoleid(roleid);
        return userEntities.stream()
                .map(userMapper::maptoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByUserid(String userid) {
        userRepositoryclient.deleteByUserid(userid);
    }

    @Override
    public void createUser(UserDTO userDTO) {
        if ( userDTO != null) {
            UserEntity user = userMapper.maptoEntity(userDTO);
            RoleEntity roleEntity = roleRepositoryclient.findByRoleid(userDTO.getRoleid()).orElse(null);
            if (user != null) {
                user.setRoleid(roleEntity);
                userRepositoryclient.save(user);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        UserEntity existingUser  = userRepositoryclient.findByUserid(userDTO.getUserid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userDTO, existingUser);
        userRepositoryclient.save(existingUser);
    }
}

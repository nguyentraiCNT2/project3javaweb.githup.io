package project3.api.admin.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.UserTokenMapper;
import project3.api.admin.service.UserTokenService;
import project3.api.user.repository.UserRepositoryclient;
import project3.api.user.repository.UserTokenRepositoryclient;
import project3.dto.UserTokenDTO;
import project3.entity.UserEntity;
import project3.entity.UserTokenEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserTokenIMPL implements UserTokenService {
    @Autowired
    private final UserTokenRepositoryclient userTokenRepository;
    private ModelMapper modelMapper;
    private UserTokenMapper userTokenMapper;
    private UserRepositoryclient userRepositoryclient;
    public UserTokenIMPL(UserTokenRepositoryclient userTokenRepository, ModelMapper modelMapper, UserTokenMapper userTokenMapper, UserRepositoryclient userRepositoryclient) {
        this.userTokenRepository = userTokenRepository;
        this.modelMapper = modelMapper;
        this.userTokenMapper = userTokenMapper;
        this.userRepositoryclient = userRepositoryclient;
    }


    @Override
    public List<UserTokenDTO> getAll(Pageable pageable) {
        List<UserTokenDTO> results = new ArrayList<>();
        List<UserTokenEntity> userTokenEntities = userTokenRepository.findAll(pageable).getContent();
        for (UserTokenEntity item: userTokenEntities
        ) {
            UserTokenDTO userTokenDTO = userTokenMapper.maptoDTO(item);
            results.add(userTokenDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) userTokenRepository.count();
    }

    @Override
    public UserTokenDTO getByUsertokenid(Long usertokenid) {
        try {
            UserTokenEntity userToken = userTokenRepository.findByUsertokenid(usertokenid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + usertokenid));
            return userTokenMapper.maptoDTO(userToken);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<UserTokenDTO> getByTokenurl(String tokenurl, Pageable pageable) {
        List<UserTokenDTO> results = new ArrayList<>();
        List<UserTokenEntity> userTokenEntities = userTokenRepository.findByTokenurl(tokenurl,pageable);
        for (UserTokenEntity item: userTokenEntities
        ) {
            UserTokenDTO userTokenDTO = userTokenMapper.maptoDTO(item);
            results.add(userTokenDTO);
        }
        return results;
    }

    @Override
    public List<UserTokenDTO> getByUserid(String userid, Pageable pageable) {
        List<UserTokenDTO> results = new ArrayList<>();
        List<UserTokenEntity> userTokenEntities = userTokenRepository.findByUserid(userid,pageable);
        for (UserTokenEntity item: userTokenEntities
        ) {
            UserTokenDTO userTokenDTO = userTokenMapper.maptoDTO(item);
            results.add(userTokenDTO);
        }
        return results;
    }

    @Override
    public void deleteByUsertokenid(Long usertokenid) {
        userTokenRepository.deleteByUsertokenid(usertokenid);
    }

    @Override
    public void createUserToken(UserTokenDTO userTokenDTO) {
        if ( userTokenDTO != null) {
            UserTokenEntity userToken = userTokenMapper.maptoEntity(userTokenDTO);
            UserEntity user = userRepositoryclient.findByUserid(userTokenDTO.getUserid()).orElse(null);
            if (userToken != null) {
                userToken.setUserid(user);
                userTokenRepository.save(userToken);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateUserToken(UserTokenDTO userTokenDTO) {
        UserTokenEntity existingUserToken  = userTokenRepository.findByUsertokenid(userTokenDTO.getUsertokenid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(userTokenDTO, existingUserToken);
        userTokenRepository.save(existingUserToken);
    }
}

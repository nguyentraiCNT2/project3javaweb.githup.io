package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.UserDTO;
import project3.dto.UserTokenDTO;
import project3.entity.UserEntity;
import project3.entity.UserTokenEntity;

@Component
public class UserTokenMapper {
    private final ModelMapper modelMapper;

    public UserTokenMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserTokenDTO maptoDTO (UserTokenEntity entity){
        UserTokenDTO dto = new UserTokenDTO();
        dto.setUsertokenid(entity.getUsertokenid());
        dto.setDatetoken(entity.getDatetoken());
        dto.setTokenurl(entity.getTokenurl());
        dto.setUserid(entity.getUserid().getUserid());
        return dto;
    }

    public UserTokenEntity maptoEntity (UserTokenDTO dto){
        UserTokenEntity entity = new UserTokenEntity();
        entity.setUsertokenid(dto.getUsertokenid());
        entity.setDatetoken(dto.getDatetoken());
        entity.setTokenurl(dto.getTokenurl());
        return entity;
    }
}

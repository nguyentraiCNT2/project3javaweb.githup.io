package project3.Mapper.Opject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import project3.dto.UserAddressDTO;
import project3.dto.UserTokenDTO;
import project3.entity.UserAddressEntity;
import project3.entity.UserTokenEntity;

@Component
public class UserAddressMapper {
    private final ModelMapper modelMapper;

    public UserAddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserAddressDTO maptoDTO (UserAddressEntity entity){
        UserAddressDTO dto = new UserAddressDTO();
        dto.setAddressid(entity.getAddressid());
        dto.setUseraddress(entity.getUseraddress());
        dto.setStatus(entity.isStatus());
        dto.setUserid(entity.getUserid().getUserid());
        return dto;
    }

    public UserAddressEntity maptoEntity (UserAddressDTO dto){
        UserAddressEntity entity = new UserAddressEntity();
        dto.setAddressid(entity.getAddressid());
        dto.setUseraddress(entity.getUseraddress());
        dto.setStatus(entity.isStatus());
        dto.setUserid(entity.getUserid().getUserid());
        return entity;
    }
}

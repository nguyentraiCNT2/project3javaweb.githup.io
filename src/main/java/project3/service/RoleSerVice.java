package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.RoleDTO;
import project3.dto.UserDTO;
import project3.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RoleSerVice {
    List<RoleDTO> getAll(Pageable pageable);
    int totalItem();
    RoleDTO getByRoleid(Long roleid);
    List<RoleDTO> getByRolename(String rolename);
    void createRole(RoleDTO roleDTO);

    void updateRole(RoleDTO roleDTO);
    void deleteByRoleid(Long roleid);

}

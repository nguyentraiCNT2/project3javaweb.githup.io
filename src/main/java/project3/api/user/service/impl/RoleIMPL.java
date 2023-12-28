package project3.api.user.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.RoleMapper;
import project3.api.user.repository.RoleRepositoryclient;
import project3.dto.RoleDTO;
import project3.entity.RoleEntity;
import project3.api.user.service.RoleSerVice;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleIMPL implements RoleSerVice {
    @Autowired
    private final RoleRepositoryclient roleRepositoryclient;
    private ModelMapper modelMapper;
    private RoleMapper roleMapper;

    public RoleIMPL(RoleRepositoryclient roleRepositoryclient, ModelMapper modelMapper, RoleMapper roleMapper) {
        this.roleRepositoryclient = roleRepositoryclient;
        this.modelMapper = modelMapper;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> getAll(Pageable pageable) {
        List<RoleDTO> results = new ArrayList<>();
        List<RoleEntity> roleEntities = roleRepositoryclient.findAll(pageable).getContent();
        for (RoleEntity item: roleEntities
        ) {
            RoleDTO roleDTO = roleMapper.maptoDTO(item);
            results.add(roleDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) roleRepositoryclient.count();
    }

    @Override
    public RoleDTO getByRoleid(Long roleid) {
        try {
            RoleEntity role = roleRepositoryclient.findByRoleid(roleid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + roleid));
            return roleMapper.maptoDTO(role);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<RoleDTO> getByRolename(String rolename) {
        try {
            List<RoleEntity> role  = roleRepositoryclient.findByRolename(rolename);
            return role.stream()
                    .map(roleMapper::maptoDTO)
                    .collect(Collectors.toList());
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public void createRole(RoleDTO roleDTO) {
        if ( roleDTO != null) {
            RoleEntity role = roleMapper.maptoEntity(roleDTO);
            if (role != null) {
                roleRepositoryclient.save(role);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateRole(RoleDTO roleDTO) {
        RoleEntity existingRole  = roleRepositoryclient.findByRoleid(roleDTO.getRoleid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(roleDTO, existingRole);
        roleRepositoryclient.save(existingRole);
    }

    @Override
    public void deleteByRoleid(Long roleid) {
        roleRepositoryclient.deleteByRoleid(roleid);
    }
}

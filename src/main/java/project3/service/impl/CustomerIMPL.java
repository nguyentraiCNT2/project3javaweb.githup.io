package project3.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.service.CustomersService;
import project3.Mapper.Opject.CustomersMapper;
import project3.repository.CustomersRepository;
import project3.repository.RoleRepository;
import project3.dto.CustomersDTO;
import project3.entity.*;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerIMPL implements CustomersService {
    @Autowired
    private final CustomersRepository customersRepository;
    private ModelMapper  modelMapper;
    private CustomersMapper customersMapper;
    private RoleRepository roleRepository;

    public CustomerIMPL(CustomersRepository customersRepository, ModelMapper modelMapper, CustomersMapper customersMapper, RoleRepository roleRepository) {
        this.customersRepository = customersRepository;
        this.modelMapper = modelMapper;
        this.customersMapper = customersMapper;
        this.roleRepository = roleRepository;
    }


    @Override
    public List<CustomersDTO> getAll(Pageable pageable) {
        List<CustomersDTO> results = new ArrayList<>();
        List<CustomersEntity> customersEntities = customersRepository.findAll(pageable).getContent();
        for (CustomersEntity item: customersEntities
        ) {
            CustomersDTO DTO = customersMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int)customersRepository.count();
    }

    @Override
    public CustomersDTO getByCustomerid(String customerid) {
        try {
            CustomersEntity customers = customersRepository.findByCustomerid(customerid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + customerid));
            return customersMapper.maptoDTO(customers);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<CustomersDTO> getByCustomername(String customername, Pageable pageable) {
        List<CustomersDTO> results = new ArrayList<>();
        List<CustomersEntity> customersEntities = customersRepository.findByCustomername(customername,pageable);
        for (CustomersEntity item: customersEntities
        ) {
            CustomersDTO DTO = customersMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<CustomersDTO> getByEmail(String email, Pageable pageable) {
        List<CustomersDTO> results = new ArrayList<>();
        List<CustomersEntity> customersEntities = customersRepository.findByEmail(email,pageable);
        for (CustomersEntity item: customersEntities
        ) {
            CustomersDTO DTO = customersMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<CustomersDTO> getByRoleid(Long roleid, Pageable pageable) {
        List<CustomersDTO> results = new ArrayList<>();
        List<CustomersEntity> customersEntities = customersRepository.findByRoleid(roleid,pageable);
        for (CustomersEntity item: customersEntities
        ) {
            CustomersDTO DTO = customersMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByCustomerid(String customerid) {
        customersRepository.deleteByCustomerid(customerid);
    }

    @Override
    public void createCustomers(CustomersDTO customersDTO) {
        if ( customersDTO != null) {
            CustomersEntity customers = customersMapper.maptoEntity(customersDTO);
            RoleEntity role = roleRepository.findByRoleid(customersDTO.getRoleid()).orElse(null);
            if (customers != null) {
                customers.setRoleid(role);
                customersRepository.save(customers);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateCustomers(CustomersDTO customersDTO) {
        CustomersEntity existingCustomers  = customersRepository.findByCustomerid(customersDTO.getCustomerid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(customersDTO, existingCustomers);
        customersRepository.save(existingCustomers);
    }
}

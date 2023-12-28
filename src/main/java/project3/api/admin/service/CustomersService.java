package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.CustomersDTO;
import project3.dto.ShipDTO;
import project3.entity.CustomersEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersService {
 List<CustomersDTO> getAll(Pageable pageable);
 int totalItem();
   CustomersDTO getByCustomerid(String customerid);
    List<CustomersDTO> getByCustomername(String customername, Pageable pageable);
    List<CustomersDTO> getByEmail(String email, Pageable pageable);
    List<CustomersDTO> getByRoleid(Long roleid, Pageable pageable);
    void deleteByCustomerid(String customerid);
    void createCustomers(CustomersDTO customersDTO);
    void updateCustomers(CustomersDTO customersDTO);
}

package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CustomersEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepositoryclient extends JpaRepository<CustomersEntity,String> {
    Optional<CustomersEntity> findByCustomerid(String customerid);
    List<CustomersEntity> findByCustomername(String customername);
    List<CustomersEntity> findByEmail(String email);
    List<CustomersEntity> findByRoleid(Long roleid);
    void deleteByCustomerid(String customerid);
    CustomersEntity saveAndFlush(CustomersEntity customersEntity);
}

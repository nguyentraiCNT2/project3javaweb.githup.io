package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CustomersEntity;
import project3.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity,String> {
    Optional<CustomersEntity> findByCustomerid(String customerid);
    List<CustomersEntity> findByCustomername(String customername);
    List<CustomersEntity> findByEmail(String email);
    List<CustomersEntity> findByRoleid(Long roleid);
    void deleteByCustomerid(String customerid);
    CustomersEntity saveAndFlush(CustomersEntity customersEntity);
}

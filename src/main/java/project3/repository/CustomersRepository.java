package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.CustomersEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<CustomersEntity,String> {
    Optional<CustomersEntity> findByCustomerid(String customerid);
    List<CustomersEntity> findByCustomername(String customername, Pageable pageable);
    List<CustomersEntity> findByEmail(String email, Pageable pageable);
    List<CustomersEntity> findByRoleid(Long roleid, Pageable pageable);
    void deleteByCustomerid(String customerid);
    CustomersEntity saveAndFlush(CustomersEntity customersEntity);
}

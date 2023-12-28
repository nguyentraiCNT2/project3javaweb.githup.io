package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserAddressEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {
    Optional<UserAddressEntity> findByUseraddressid(Long useraddressid);
    List<UserAddressEntity> findByUseraddress(String useraddress, Pageable pageable);
    List<UserAddressEntity> findByUserid(String userid, Pageable pageable);
    void deleteByUseraddressid(Long useraddressid);
    UserAddressEntity saveAndFlush(UserAddressEntity userAddressEntity);
}

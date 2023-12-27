package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserAddressEntity;
import project3.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {
    Optional<UserAddressEntity> findByAddressid(Long addressid);
    List<UserAddressEntity> findByUseraddress(String useraddress);
    List<UserAddressEntity> findByUserid(String userid);
    void deleteByAddressid(Long addressid);
    UserAddressEntity saveAndFlush(UserAddressEntity userAddressEntity);
}

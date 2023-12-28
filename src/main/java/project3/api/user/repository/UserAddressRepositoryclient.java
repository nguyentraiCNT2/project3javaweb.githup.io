package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserAddressEntity;
import project3.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAddressRepositoryclient extends JpaRepository<UserAddressEntity, Long> {
    Optional<UserAddressEntity> findByUseraddressid(Long useraddressid);
    List<UserAddressEntity> findByUseraddress(String useraddress);
    List<UserAddressEntity> findByUserid(String userid);
    void deleteByUseraddressid(Long useraddressid);
    UserAddressEntity saveAndFlush(UserAddressEntity userAddressEntity);
}

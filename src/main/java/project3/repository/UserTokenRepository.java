package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.RoleEntity;
import project3.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long> {
    Optional<UserTokenEntity> findByUsertokenid(Long usertokenid);
    List<UserTokenEntity> findByTokenurl(String tokenurl);
    List<UserTokenEntity> findByUserid(String userid);
    void deleteByUsertokenid(Long usertokenid);
    UserTokenEntity saveAndFlush(UserTokenEntity userTokenEntity);
}

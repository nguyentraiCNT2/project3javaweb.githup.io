package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserTokenEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTokenRepository extends JpaRepository<UserTokenEntity, Long> {
    Optional<UserTokenEntity> findByUsertokenid(Long usertokenid);
    List<UserTokenEntity> findByTokenurl(String tokenurl, Pageable pageable);
    List<UserTokenEntity> findByUserid(String userid, Pageable pageable);
    void deleteByUsertokenid(Long usertokenid);
    UserTokenEntity saveAndFlush(UserTokenEntity userTokenEntity);
}

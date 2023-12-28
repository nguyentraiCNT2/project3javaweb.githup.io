package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByUserid(String userid);
    List<UserEntity> findByUsername(String username, Pageable pageable);
    List<UserEntity> findByEmail(String email);
    List<UserEntity> findByRoleid(Long roleid,Pageable pageable);
    void deleteByUserid(String userid);
    UserEntity saveAndFlush(UserEntity userEntity);

}

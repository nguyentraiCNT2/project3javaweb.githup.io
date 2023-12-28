package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepositoryclient extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRoleid(Long roleid);
    List<RoleEntity> findByRolename(String rolename);
    void deleteByRoleid(Long roleid);
    RoleEntity saveAndFlush(RoleEntity roleEntity);
}

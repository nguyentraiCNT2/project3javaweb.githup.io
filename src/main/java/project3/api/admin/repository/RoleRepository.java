package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.RoleEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> findByRoleid(Long roleid);
    List<RoleEntity> findByRolename(String rolename);
    void deleteByRoleid(Long roleid);
    RoleEntity saveAndFlush(RoleEntity roleEntity);
}

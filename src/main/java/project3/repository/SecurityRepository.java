package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.UserEntity;

import java.util.List;

@Repository
public interface SecurityRepository extends JpaRepository<UserEntity, String> {
    List<UserEntity> findByUsername(String username);
}

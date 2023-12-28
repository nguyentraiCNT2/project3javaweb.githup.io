package project3.api.admin.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoveListRepository extends JpaRepository<LoveListEntity,Long> {
    Optional<LoveListEntity> findByLovelistid(Long lovelistid);
    List<LoveListEntity> findByUserid(String userid, Pageable pageable);
    List<LoveListEntity> findByLovelistname(String lovelistname, Pageable pageable);
    void deleteByLovelistid(Long lovelistid);
    LoveListEntity saveAndFlush(LoveListEntity loveListEntity);
}

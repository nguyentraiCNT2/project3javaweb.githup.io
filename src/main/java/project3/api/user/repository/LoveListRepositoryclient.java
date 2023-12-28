package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.LoveListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoveListRepositoryclient extends JpaRepository<LoveListEntity,Long> {
    Optional<LoveListEntity> findByLovelistid(Long lovelistid);
    List<LoveListEntity> findByUserid(String userid);
    List<LoveListEntity> findByLovelistname(String lovelistname);
    void deleteByLovelistid(Long lovelistid);
    LoveListEntity saveAndFlush(LoveListEntity loveListEntity);
}

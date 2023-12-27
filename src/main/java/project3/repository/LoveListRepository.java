package project3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.LoveListEntity;
import project3.entity.OrderdetailsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoveListRepository extends JpaRepository<LoveListEntity,Long> {
    Optional<LoveListEntity> findByLovelistid(Long lovelistid);
    List<LoveListEntity> findByUserid(String userid);
    List<LoveListEntity> findByLovelistname(String lovelistname);
    void deleteByLovelistid(Long lovelistid);
    LoveListEntity saveAndFlush(LoveListEntity loveListEntity);
}

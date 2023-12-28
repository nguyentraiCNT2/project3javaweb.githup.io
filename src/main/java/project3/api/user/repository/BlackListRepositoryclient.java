package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.BlackListEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlackListRepositoryclient extends JpaRepository<BlackListEntity,Long> {
    Optional<BlackListEntity> findByBalcklistid(Long balcklistid);
    List<BlackListEntity> findByBlacklistname(String blacklistname);
    List<BlackListEntity> findByUserid(String userid);
    void deleteByBalcklistid(Long balcklistid);
    BlackListEntity saveAndFlush(BlackListEntity blackListEntity);
}

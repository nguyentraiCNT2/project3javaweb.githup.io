package project3.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.NewsEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    Optional<NewsEntity> findByNewsid(Long newsid);
    List<NewsEntity> findByTitle(String title, Pageable pageable);
    void deleteByNewsid(Long newsid);
    NewsEntity saveAndFlush(NewsEntity newsEntity);
}

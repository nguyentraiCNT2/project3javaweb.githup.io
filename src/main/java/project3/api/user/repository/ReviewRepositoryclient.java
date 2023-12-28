package project3.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.entity.ProductsEntity;
import project3.entity.ReviewEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepositoryclient extends JpaRepository<ReviewEntity,Long> {
    Optional<ReviewEntity> findByReviewid(Long reviewid);
    List<ReviewEntity> findByUserid(String userid);
    List<ReviewEntity> findByProductsid(Long productsid);
    List<ReviewEntity> findByEvaluate(Long evaluate);
    void deleteByReviewid(Long reviewid);
    ReviewEntity saveAndFlush(ReviewEntity reviewEntity);
}

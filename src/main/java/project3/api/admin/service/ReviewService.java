package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.ReviewDTO;
import project3.dto.ShipDTO;
import project3.entity.ReviewEntity;

import java.util.List;
import java.util.Optional;
public interface ReviewService{
    List<ReviewDTO> getAll(Pageable pageable);
    int totalItem();
    ReviewDTO getByReviewid(Long reviewid);
    List<ReviewDTO> getByUserid(String userid, Pageable pageable);
    List<ReviewDTO> getByProductsid(Long productsid, Pageable pageable);
    List<ReviewDTO> getByEvaluate(Long evaluate, Pageable pageable);
    void deleteByReviewid(Long reviewid);
    void createReview(ReviewDTO reviewDTO);
    void updateReview(ReviewDTO reviewDTO);
}

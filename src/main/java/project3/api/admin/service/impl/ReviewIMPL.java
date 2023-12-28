package project3.api.admin.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project3.Mapper.Opject.ReveiwMapper;
import project3.api.admin.repository.ProductsRepository;
import project3.api.admin.repository.ReviewRepository;
import project3.api.admin.repository.UserRepository;
import project3.api.admin.service.ReviewService;
import project3.dto.ReviewDTO;
import project3.dto.RoleDTO;
import project3.entity.ProductsEntity;
import project3.entity.ReviewEntity;
import project3.entity.RoleEntity;
import project3.entity.UserEntity;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewIMPL implements ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;
    private ModelMapper modelMapper;
    private ReveiwMapper reveiwMapper;
    private UserRepository userRepository;
    private ProductsRepository productsRepository;

    public ReviewIMPL(ReviewRepository reviewRepository, ModelMapper modelMapper, ReveiwMapper reveiwMapper, UserRepository userRepository, ProductsRepository productsRepository) {
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
        this.reveiwMapper = reveiwMapper;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public List<ReviewDTO> getAll(Pageable pageable) {
        List<ReviewDTO> results = new ArrayList<>();
        List<ReviewEntity> reviewEntities = reviewRepository.findAll(pageable).getContent();
        for (ReviewEntity item: reviewEntities
        ) {
            ReviewDTO DTO = reveiwMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) reviewRepository.count();
    }

    @Override
    public ReviewDTO getByReviewid(Long reviewid) {
        try {
            ReviewEntity review = reviewRepository.findByReviewid(reviewid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + reviewid));
            return reveiwMapper.maptoDTO(review);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }

    @Override
    public List<ReviewDTO> getByUserid(String userid, Pageable pageable) {
        List<ReviewDTO> results = new ArrayList<>();
        List<ReviewEntity> reviewEntities = reviewRepository.findByUserid(userid,pageable);
        for (ReviewEntity item: reviewEntities
        ) {
            ReviewDTO DTO = reveiwMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ReviewDTO> getByProductsid(Long productsid, Pageable pageable) {
        List<ReviewDTO> results = new ArrayList<>();
        List<ReviewEntity> reviewEntities = reviewRepository.findByProductsid(productsid,pageable);
        for (ReviewEntity item: reviewEntities
        ) {
            ReviewDTO DTO = reveiwMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public List<ReviewDTO> getByEvaluate(Long evaluate, Pageable pageable) {
        List<ReviewDTO> results = new ArrayList<>();
        List<ReviewEntity> reviewEntities = reviewRepository.findByEvaluate(evaluate,pageable);
        for (ReviewEntity item: reviewEntities
        ) {
            ReviewDTO DTO = reveiwMapper.maptoDTO(item);
            results.add(DTO);
        }
        return results;
    }

    @Override
    public void deleteByReviewid(Long reviewid) {
        reviewRepository.deleteByReviewid(reviewid);
    }

    @Override
    public void createReview(ReviewDTO reviewDTO) {
        if ( reviewDTO != null) {
            ReviewEntity review = reveiwMapper.maptoEntity(reviewDTO);
            UserEntity user = userRepository.findByUserid(reviewDTO.getUserid()).orElse(null);
            ProductsEntity products = productsRepository.findByProductsid(reviewDTO.getProductsid()).orElse(null);
            if (review != null) {
                review.setUserid(user);
                review.setProductsid(products);
                reviewRepository.save(review);
            } else {
                throw new RuntimeException("Không lấy được dữ liệu của Entity");
            }
        }
    }

    @Override
    public void updateReview(ReviewDTO reviewDTO) {
        ReviewEntity existingReview  = reviewRepository.findByReviewid(reviewDTO.getReviewid())
                .orElseThrow(() -> new RuntimeException("Khong tim thay du lieu User"));
        modelMapper.map(reviewDTO, existingReview);
        reviewRepository.save(existingReview);
    }
}

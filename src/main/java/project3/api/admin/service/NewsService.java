package project3.api.admin.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project3.dto.NewsDTO;
import project3.dto.ShipDTO;
import project3.entity.NewsEntity;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    List<NewsDTO> getAll(Pageable pageable);
    int totalItem();
    NewsDTO getByNewsid(Long newsid);
    List<NewsDTO> getByTitle(String title, Pageable pageable);
    void deleteByNewsid(Long newsid);
    void createNews(NewsDTO newsDTO);
    void updateNews(NewsDTO newsDTO);
}

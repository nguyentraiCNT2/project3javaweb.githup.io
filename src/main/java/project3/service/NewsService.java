package project3.service;

import org.springframework.data.domain.Pageable;
import project3.dto.NewsDTO;

import java.util.List;

public interface NewsService {
    List<NewsDTO> getAll(Pageable pageable);
    int totalItem();
    NewsDTO getByNewsid(Long newsid);
    List<NewsDTO> getByTitle(String title, Pageable pageable);
    void deleteByNewsid(Long newsid);
    void createNews(NewsDTO newsDTO);
    void updateNews(NewsDTO newsDTO);
}

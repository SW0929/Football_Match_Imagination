package server.kickoff.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import server.kickoff.domain.Article;
import server.kickoff.repository.ArticleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional
    public List<Article> findAllArticle() {
        return articleRepository.findAll();
    }


}

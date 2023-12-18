package server.kickoff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import server.kickoff.domain.Article;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {


}

package wooteco.helloworld.jdbc.relation;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}

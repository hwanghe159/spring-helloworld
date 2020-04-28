package wooteco.helloworld.jdbc.relation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Override
    List<Author> findAll();
}

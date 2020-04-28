package wooteco.helloworld.jdbc.relation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJdbcTest
@Transactional
public class ArticleRepositoryTest {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @DisplayName("게시글 생성 후 댓글 추가")
    @Test
    void addComment() {
        Article article = new Article("title", "content");
        article.addComments(new Comment("댓글1"));
        Article oneCommentArticle = articleRepository.save(article);

        oneCommentArticle.addComments(new Comment("댓글2"));
        oneCommentArticle.addComments(new Comment("댓글3"));

        Article threeCommentArticle = articleRepository.save(oneCommentArticle);

        assertThat(threeCommentArticle.getId()).isNotNull();
        assertThat(threeCommentArticle.getComments()).hasSize(3);
    }

    @DisplayName("게시글/댓글 생성 후 댓글 제거")
    @Test
    void removeComment() {
        Article article = new Article("title", "content");
        article.addComments(new Comment("댓글1"));
        article.addComments(new Comment("댓글2"));
        Article persistArticle = articleRepository.save(article);

        Comment comment = persistArticle.getComments().stream()
                .findFirst()
                .orElseThrow(RuntimeException::new);
        persistArticle.removeComment(comment);
        articleRepository.save(article);

        assertThat(persistArticle.getId()).isNotNull();
        assertThat(persistArticle.getComments()).hasSize(1);
    }

    @DisplayName("게시글/댓글 생성 후 게시글 제거")
    @Test
    void removeArticleWithComments() {
        Article article = new Article("title", "content");
        article.addComments(new Comment("댓글1"));
        article.addComments(new Comment("댓글2"));
        Article persistArticle = articleRepository.save(article);

        articleRepository.delete(persistArticle);

        assertThat(articleRepository.findAll()).hasSize(0);
    }

    @DisplayName("작성자 포함 후 게시글 생성")
    @Test
    void createArticle() {
        Author author = authorRepository.save(new Author("브라운"));
        Article article = new Article("title", "content", author);
        articleRepository.save(article);

        Article persistArticle = articleRepository.findById(article.getId()).orElseThrow(RuntimeException::new);

        assertThat(persistArticle).isNotNull();
    }

    @DisplayName("게시글 생성 후 작성자 삭제")
    @Test
    void deleteAuthorAfterArticleIsDeleted() {
        Author author = authorRepository.save(new Author("브라운"));
        Article article = articleRepository.save(new Article("title", "content", author));

        articleRepository.delete(article);

        assertThat(articleRepository.findAll()).hasSize(0);
        assertThat(authorRepository.findAll()).hasSize(1);
    }
}

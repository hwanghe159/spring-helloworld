package wooteco.helloworld.jdbc.relation;

import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

public class Article {
    private Long id;
    private String title;
    private String content;

    // TODO: comments 참조
    // TODO: author 참조

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Article(String title, String content, Author author) {
        this.title = title;
        this.content = content;
    }

    public void addComments(Comment comment) {
    }

    public void removeComment(Comment comment) {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Set<Comment> getComments() {
        return null;
    }

}


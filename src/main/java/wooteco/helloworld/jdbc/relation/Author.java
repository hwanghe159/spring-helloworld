package wooteco.helloworld.jdbc.relation;

import org.springframework.data.annotation.Id;

public class Author {
    private Long id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}

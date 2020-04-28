package wooteco.helloworld.jdbc.simple;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table("user")
public class User {
    @Id
    private Long id;
    private String name;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public User() {
    }

    public User(String name) {
        this.name = name;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public String getCreateAtFormat(){
        return createAt.format(DateTimeFormatter.ISO_DATE_TIME);
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void update(User author) {
        this.name = author.name;
        this.updateAt = LocalDateTime.now();
    }
}

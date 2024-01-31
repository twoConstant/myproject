package me.sangsu.springbootdeveloper.dto;

import lombok.Getter;
import me.sangsu.springbootdeveloper.domain.Article;

@Getter
public class DeleteArticleResponse {
    private final long id;

    public DeleteArticleResponse(Article article) {
        this.id = article.getId();
    }
}

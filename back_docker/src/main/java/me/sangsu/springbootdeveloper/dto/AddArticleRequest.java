package me.sangsu.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.sangsu.springbootdeveloper.domain.Article;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity() {
        Article request = Article.builder()
                .title(this.title)
                .content(this.content == null ? "내용 없음" : this.content)
                .build();
        return request;
    }
}

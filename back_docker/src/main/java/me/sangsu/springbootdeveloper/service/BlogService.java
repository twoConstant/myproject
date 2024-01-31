package me.sangsu.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.sangsu.springbootdeveloper.domain.Article;
import me.sangsu.springbootdeveloper.dto.AddArticleRequest;
import me.sangsu.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    // 글 저장하고 해당 아티클을 반환
    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    // 글 목록 조회
    public List<Article> getAllArticles() {
        return blogRepository.findAll();
    }

    // 글 조회
    public Article getArticleById(long articleId) {
        Article article = blogRepository.findById(articleId)
                .orElseThrow(()->new IllegalArgumentException("not found: " + articleId));
        return article;
    }

    // 글 삭제
    public Optional<Article> deletArticleById(long articleId) {
        Optional<Article> article = blogRepository.findById(articleId);
        blogRepository.deleteById(articleId);
        return article;
    }
}

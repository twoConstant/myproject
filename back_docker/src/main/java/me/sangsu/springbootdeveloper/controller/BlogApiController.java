package me.sangsu.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.sangsu.springbootdeveloper.domain.Article;
import me.sangsu.springbootdeveloper.dto.AddArticleRequest;
import me.sangsu.springbootdeveloper.dto.ArticleResponse;
import me.sangsu.springbootdeveloper.dto.DeleteArticleResponse;
import me.sangsu.springbootdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BlogApiController {
    private final BlogService blogService;

    // url : /api/articles
    // method : Post
    // return : 생성된 객체
    @PostMapping("/api/articles")
    public ResponseEntity<Article> save(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }


    // url : /api/articles
    // method : GET
    // return : List<Article>
    @GetMapping("/api/articles")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> allArticles = blogService.getAllArticles();
        return ResponseEntity.status(HttpStatus.OK).body(allArticles);
    }


    // url : /api/aritlces/{article_id}
    // method : GET
    // return : Article article
    @GetMapping("/api/articles/{article_id}")
    public ResponseEntity<ArticleResponse> getArticle(@PathVariable long article_id) {
        Article findArticle = blogService.getArticleById(article_id);
        ArticleResponse articleResponse = new ArticleResponse(findArticle);
        return ResponseEntity.ok().body(articleResponse);
    }

    // url : /api/articles/{article_id}
    // method : Delete
    // return : 삭제됨
    @DeleteMapping("/api/articles/{article_id}")
    public ResponseEntity<DeleteArticleResponse> deleteArticleById(@PathVariable long article_id) {
        Optional<Article> deletedArticle = blogService.deletArticleById(article_id);
        DeleteArticleResponse deleteArticleResponse = new DeleteArticleResponse(deletedArticle.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(deleteArticleResponse);
    }

}

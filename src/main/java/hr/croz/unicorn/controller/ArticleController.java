package hr.croz.unicorn.controller;

import hr.croz.unicorn.dto.ArticleDto;
import hr.croz.unicorn.model.Article;
import hr.croz.unicorn.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("api/article")
@Slf4j
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<List<ArticleDto>> getAllArticles() {
        try {
            return ResponseEntity.ok().body(articleService.getAllAsDto());
        } catch (Exception e) {
            log.error("getAllArticles...Error while getting all articles", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Article> saveNewArticle(@RequestBody Article article) {
        try {
            return ResponseEntity.ok().body(articleService.save(article));
        } catch (Exception e) {
            log.error("saveNewArticle...Error while saving new article", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity updateArticle(@RequestBody Article updatedArticle) {
        try {
            articleService.updateArticle(updatedArticle);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("saveNewArticle...Error while saving new article", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping(path="/{serialNumber}")
    @Transactional
    public ResponseEntity deleteArticleBySerialNumber(@PathVariable("serialNumber") String serialNumber) {
        try {
            articleService.deleteArticleBySerialNumber(serialNumber);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error("deleteParBySerialNumber...Error while deleting part by SN", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}

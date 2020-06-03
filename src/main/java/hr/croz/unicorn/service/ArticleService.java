package hr.croz.unicorn.service;

import hr.croz.unicorn.dto.ArticleDto;
import hr.croz.unicorn.model.Article;

import java.util.List;

public interface ArticleService extends CRUDService<Article, Long> {
    void updateArticle(Article newArticle);

    Double getFinalPriceForArticle(Article article);

    List<ArticleDto> getAllAsDto();

    void deleteArticleBySerialNumber(String serialNumber);
}
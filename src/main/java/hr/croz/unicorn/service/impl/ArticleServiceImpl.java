package hr.croz.unicorn.service.impl;

import hr.croz.unicorn.dto.ArticleDto;
import hr.croz.unicorn.model.Article;
import hr.croz.unicorn.repository.ArticleRepository;
import hr.croz.unicorn.service.AbstractService;
import hr.croz.unicorn.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl extends AbstractService<Article, Long> implements ArticleService {
    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository repository) {
        super(repository);
        this.articleRepository = repository;
    }

    @Transactional
    @Override
    public void updateArticle(Article newArticle) {
        double newBasePrice = newArticle.getBasePrice();
        String serialNumber = newArticle.getSerialNumber();
        this.articleRepository.updateArticle(newBasePrice, serialNumber);
    }

    @Override
    public void deleteArticleBySerialNumber(String serialNumber) {
        this.articleRepository.deleteArticleBySerialNumber(serialNumber);
    }

    @Override
    public List<Article> getAll() {
        List<Article> articles = super.getAll();
        if (articles == null) {
            log.info("No articles found");
            return Collections.emptyList();
        }

        articles.forEach(article -> article.setFinalPrice(getFinalPriceForArticle(article)));

        return articles;
    }

    @Override
    public Double getFinalPriceForArticle(Article article) {
        double finalPrice = article.getBasePrice();
        if (article.getAction() != null) {
            finalPrice = finalPrice - finalPrice * article.getAction().getActionPercentage() / 100.;
        }

        return finalPrice;
    }

    @Override
    public List<ArticleDto> getAllAsDto() {
        List<Article> articles = getAll();
        List<ArticleDto> dtos = new ArrayList<>(articles.size());

        articles.forEach(article -> dtos.add(
                ArticleDto.builder()
                        .serialNumber(article.getSerialNumber())
                        .finalPrice(getFinalPriceForArticle(article))
                        .build()));

        return dtos;
    }
}

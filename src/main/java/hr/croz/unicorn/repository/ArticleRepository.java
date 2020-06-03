package hr.croz.unicorn.repository;

import hr.croz.unicorn.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Modifying
    @Query("update Article a set a.basePrice = :newBasePrice where a.serialNumber like :serialNumber ")
    void updateArticle(@Param("newBasePrice") double newBasePrice, @Param("serialNumber") String serialNumber);

    @Modifying
    @Query("delete from Article a where a.serialNumber like :serialNumber")
    void deleteArticleBySerialNumber(@Param("serialNumber") String serialNumber);
}

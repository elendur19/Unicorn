package hr.croz.unicorn.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
    private String serialNumber;
    private Double finalPrice;
}

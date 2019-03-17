package hacker.rank.design;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;


@Builder
@EqualsAndHashCode
@ToString
@Getter
public class Product {
    
    private String productCode;
    private BigDecimal price;
}

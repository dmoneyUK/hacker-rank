package hacker.rank.design;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;


@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Order {
    
    private Product product;
    private int quantity;
    
    public BigDecimal getCost() {
        return product
                .getPrice()
                .multiply(BigDecimal.valueOf(quantity));
    }
}

package hacker.rank.design;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@ToString
@EqualsAndHashCode
@Builder
@Getter
public class TotalCostBasedDiscount implements Discount {
    
    private BigDecimal requiredCost;
    private int x;
    private int y;
}

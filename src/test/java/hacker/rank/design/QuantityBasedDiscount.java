package hacker.rank.design;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@Builder
@Getter
public class QuantityBasedDiscount implements Discount {
    
    private int x;
    private int y;
}
    


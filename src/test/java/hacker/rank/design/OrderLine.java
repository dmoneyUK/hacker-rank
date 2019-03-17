package hacker.rank.design;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;


@Builder
@EqualsAndHashCode
@ToString
@Getter
public class OrderLine {
    
    private List<Order> orders;
    
    public BigDecimal getTotal() {
        return orders
                .stream()
                .map(order -> order.getCost())
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    }
    
}

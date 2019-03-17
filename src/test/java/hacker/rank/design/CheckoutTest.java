package hacker.rank.design;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.function.BiFunction;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutTest {
    
    private Product PROD_A = Product.builder()
                                    .productCode("PRO_A")
                                    .price(BigDecimal.valueOf(10))
                                    .build();
    
    private Product PROD_B = Product.builder()
                                    .productCode("PRO_B")
                                    .price(BigDecimal.valueOf(40))
                                    .build();
    
    @Test
    public void testCheckout() {
        Order orderA = Order.builder()
                            .product(PROD_A)
                            .quantity(3)
                            .build();
        Order orderB = Order.builder()
                            .product(PROD_B)
                            .quantity(1)
                            .build();
        
        OrderLine orderLine = OrderLine.builder()
                                       .orders(Arrays.asList(orderA, orderB))
                                       .build();
        
        QuantityBasedDiscount threeToTwoDiscount = QuantityBasedDiscount.builder()
                                                                        .x(2)
                                                                        .y(3)
                                                                        .build();
        
        BiFunction<Order, QuantityBasedDiscount, BigDecimal> giveQuantityBasedDiscount =
                (order, discount) -> {
                    if (hasQuantityTimesOfY(order, discount)) {
                        return order.getCost()
                                    .multiply(BigDecimal.valueOf(discount.getX()))
                                    .divide(BigDecimal.valueOf(discount.getY()));
                    }
                    return order.getCost();
                    
                };
        
        TotalCostBasedDiscount tenPercentOffOverFiftyDiscount = TotalCostBasedDiscount.builder()
                                                                                      .requiredCost(new BigDecimal(50))
                                                                                      .x(9)
                                                                                      .y(10)
                                                                                      .build();
        
        BiFunction<BigDecimal, TotalCostBasedDiscount, BigDecimal> giveTotalCostBasedPercentageDiscount =
                (totalcost, discount) -> {
                    if (totalcost.compareTo(discount.getRequiredCost()) >= 0) {
                        return totalcost
                                .multiply(BigDecimal.valueOf(discount.getX()))
                                .divide(BigDecimal.valueOf(discount.getY()));
                    }
                    return totalcost;
                    
                };
        
        BigDecimal payment = orderLine.getOrders()
                                      .stream()
                                      .map(order -> giveQuantityBasedDiscount.apply(order, threeToTwoDiscount))
                                      .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));
    
        payment = giveTotalCostBasedPercentageDiscount.apply(payment, tenPercentOffOverFiftyDiscount);
        
        assertThat(payment).isEqualTo(BigDecimal.valueOf(54));
        
    }
    
    private boolean hasQuantityTimesOfY(Order order, QuantityBasedDiscount discount) {
        return order.getQuantity() % discount.getY() == 0;
    }
    
}

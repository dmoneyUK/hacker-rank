package hacker.rank.design;

import java.math.BigDecimal;
import java.util.function.Function;

public abstract class Checkout {
    
    public static BigDecimal checkout(Function<Order, BigDecimal> calculate, Order order){
        return calculate.apply(order);
    }
    
}

package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;

public interface OrderServcice {
    Order addProductToOrder (Long order_id, Long product_id, Long amount);
    Order getSum(Order order);
    Order createOrder();

    Order removeProductFromOrder (Long order_id, Long p_id);
    Order updateAmountOfProduct (Long oId, Long pId, Long amount);
}

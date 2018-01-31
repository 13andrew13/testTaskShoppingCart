package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;

public interface OrderServcice {
    Order addProductToOrder (Order order, Long id, Long amount);
}

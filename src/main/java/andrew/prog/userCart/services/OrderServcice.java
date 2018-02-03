package andrew.prog.userCart.services;

import andrew.prog.userCart.exceptions.NoOrderException;
import andrew.prog.userCart.exceptions.NoProductException;
import andrew.prog.userCart.model.Order;

public interface OrderServcice {
    Order addProductToOrder (Long order_id, Long product_id, Long amount) throws NoOrderException, NoProductException;
    Order createOrder();

    Order removeProductFromOrder (Long order_id, Long p_id) throws NoOrderException, NoProductException;
    Order updateAmountOfProduct (Long oId, Long pId, Long amount) throws NoProductException, NoOrderException;
    Order getOrderById(Long id);
}

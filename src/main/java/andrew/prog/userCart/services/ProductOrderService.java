package andrew.prog.userCart.services;

import andrew.prog.userCart.model.ProductOrder;

public interface ProductOrderService {
    public void remove(ProductOrder productOrder);
    public ProductOrder updateAmount(Long product_id, Long amount);
}

package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.model.ProductOrder;
import andrew.prog.userCart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderServcice{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductOrderService productOrderService;

    @Override
    public Order addProductToOrder (Order order, Long id, Long amount) {
        Product product = productService.findById (id);


    }
    public Order saveOrder(Order order){
        return orderRepository.save (order);
    }
}

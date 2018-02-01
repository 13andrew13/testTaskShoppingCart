package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.model.ProductOrder;
import andrew.prog.userCart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class OrderServiceImpl implements OrderServcice{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductOrderService productOrderService;

    @Override
    public Order addProductToOrder (Long order, Long id, Long amount) {
        Product product = productService.findById (id);
        Order o = orderRepository.findOne (order);
        ProductOrder pr = new ProductOrder (amount,product);
        o.addProductOrder (pr);
        return orderRepository.save (o);
    }

    public Order getSum(Order order){
        order.setCost (order.getProductList ().stream ().mapToDouble (x->x.getAmount ()*x.getProduct ().getPrice ()).sum ());
        return order;
    }
    public Order createOrder(){
        Order order = new Order ();
        return orderRepository.save (order);
    }
}

package andrew.prog.userCart.services;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.model.ProductOrder;
import andrew.prog.userCart.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith (SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderServcice orderServcice;
    @Test
    public void getSum () throws Exception {
        Order order = new Order ();
        ProductOrder productOrder = new ProductOrder ();
        productOrder.setAmount (1L);
        productOrder.setProduct (productRepository.findOne (3L));
        order.addProductOrder (productOrder);
        ProductOrder productOrder1 = new ProductOrder ();
        productOrder1.setAmount (3L);
        productOrder1.setProduct (productRepository.findOne (3L));
        order.addProductOrder (productOrder1);
        assertEquals (49.2, orderServcice.getSum (order).getCost (),1);


    }

}
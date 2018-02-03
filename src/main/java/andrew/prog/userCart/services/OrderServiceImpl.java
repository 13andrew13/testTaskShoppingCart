package andrew.prog.userCart.services;

import andrew.prog.userCart.exceptions.NoOrderException;
import andrew.prog.userCart.exceptions.NoProductException;
import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.model.Product;
import andrew.prog.userCart.model.ProductOrder;
import andrew.prog.userCart.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServcice{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductService productService;
    @Autowired
    ProductOrderService productOrderService;

    @Override
    public Order addProductToOrder (Long order, Long id, Long amount) throws NoOrderException, NoProductException {
        Product product = productService.findById (id);
        Order o;
        try {
            o = orderRepository.findOne (order);
        }catch (NullPointerException ex){
            throw new NoOrderException ("There is no suvh order");
        }
        ProductOrder productOrder = new ProductOrder ();
            productOrder.setAmount (amount);
            productOrder.setProduct (product);
            o.addProductOrder (productOrder);
        getSum (o);
        return orderRepository.save (o);
    }

    private Order getSum(Order order) throws NoOrderException {
        try {
            order.setCost (order.getProductList ().stream ().mapToDouble (x->x.getAmount ()*x.getProduct ().getPrice ()).sum ());
        }catch (Exception ex){
            throw new NoOrderException ("There is no Order");

        }
        return order;
    }
    public Order createOrder(){
        Order order = new Order ();
        return orderRepository.save (order);

    }
    public Order removeProductFromOrder(Long order, Long pId) throws NoOrderException, NoProductException {
        Order o;
        Product p = productService.findById (pId);
        try {
            o = orderRepository.findOne (order);
        }catch (NullPointerException ex){
            throw new NoOrderException ("There is no suvh order");
        }
        for (ProductOrder productOrder : o.getProductList ()) {
            if(productOrder.getProduct ().equals (p)){
                o.getProductList ().remove (productOrder);
                productOrderService.remove (productOrder);
                break;
            }
        }
        getSum (o);
        return orderRepository.save (o);
    }
    public Order updateAmountOfProduct(Long oId, Long pId, Long amount) throws NoProductException, NoOrderException {
        productOrderService.updateAmount (pId,amount);
        Order order = orderRepository.findOne (oId);
        return orderRepository.save (getSum (order));

    }

    @Override
    public Order getOrderById (Long id) {
        return orderRepository.findOne (id);
    }
}

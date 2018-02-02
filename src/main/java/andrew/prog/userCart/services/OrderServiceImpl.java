package andrew.prog.userCart.services;

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
    public Order addProductToOrder (Long order, Long id, Long amount) {
        Product product = productService.findById (id);
        Order o = orderRepository.findOne (order);
        ProductOrder productOrder = new ProductOrder ();
        //List<ProductOrder> list = o.getProductList ();
        /*if(list.isEmpty ()){*/
            productOrder.setAmount (amount);
            productOrder.setProduct (product);
            o.addProductOrder (productOrder);
     /*   } else {
            productOrder = list.stream ().filter (x->x.getProduct ().getId ()==id).findFirst ().map ((x) -> {
                 x.setAmount (x.getAmount () + amount);
                return x;
            }).orElseGet (x->)
            }

        }*/

        getSum (o);
        return orderRepository.save (o);
    }

    private Order getSum(Order order){
        order.setCost (order.getProductList ().stream ().mapToDouble (x->x.getAmount ()*x.getProduct ().getPrice ()).sum ());
        return order;
    }
    public Order createOrder(){
        Order order = new Order ();
        return orderRepository.save (order);

    }
    public Order removeProductFromOrder(Long order, Long pId){
        Order o = orderRepository.findOne (order);
        Product p = productService.findById (pId);
        //o.getProductList ().stream ().filter (x->!x.getProduct ().equals (p)).collect (Collector.of (Collectors.toList ()));
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
    public Order updateAmountOfProduct(Long oId, Long pId, Long amount){
        productOrderService.updateAmount (pId,amount);
        Order order = orderRepository.findOne (oId);
        return orderRepository.save (getSum (order));

    }

    @Override
    public Order getOrderById (Long id) {
        return orderRepository.findOne (id);
    }
}

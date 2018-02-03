package andrew.prog.userCart.controllers;

import andrew.prog.userCart.exceptions.NoOrderException;
import andrew.prog.userCart.exceptions.NoProductException;
import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.services.OrderServcice;
import andrew.prog.userCart.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/")
public class OrderController{

    @Autowired
    private OrderServcice orderServcice;
    @Autowired
    ProductOrderService productOrderService;

    @GetMapping("/create")
    @ResponseBody
    public Order createOrder(){
        return orderServcice.createOrder ();
    }

    @PostMapping("{order_id}/add/product/{p_id}/amount/{amount}")
    @ResponseBody
    public Order addProduct(@PathVariable Long order_id, @PathVariable Long p_id, @PathVariable Long amount) throws NoOrderException, NoProductException {
        return (orderServcice.addProductToOrder (order_id,p_id,amount));
    }

    @DeleteMapping("{order_id}/remove/product/{p_id}")
    @ResponseBody
    public Order removeProduct(@PathVariable Long order_id,@PathVariable Long p_id) throws NoOrderException, NoProductException {
        return  (orderServcice.removeProductFromOrder(order_id,p_id));
    }
    @PutMapping("{order_id}/update/product/{p_id}/amount/{amount}")
    @ResponseBody
    public Order updateAmountOfProducts(@PathVariable Long order_id,@PathVariable Long p_id, @PathVariable Long amount) throws NoProductException, NoOrderException {
        return  (orderServcice.updateAmountOfProduct (order_id,p_id,amount));

    }
    @GetMapping("{order_id}/get")
    @ResponseBody
    public Order getOrder(@PathVariable Long order_id){
        return orderServcice.getOrderById (order_id);
    }






}

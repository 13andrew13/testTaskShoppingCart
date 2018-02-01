package andrew.prog.userCart.controllers;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.services.OrderServcice;
import andrew.prog.userCart.services.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("{order_id}/add/product/{p_id}/amount/{amount}")
    @ResponseBody
    public Order addProduct(@PathVariable Long order_id,@PathVariable Long p_id, @PathVariable Long amount){
        return orderServcice.addProductToOrder (order_id,p_id,amount);
    }

    @GetMapping("{order_id}/remove/product/{p_id}")
    @ResponseBody
    public Order removeProduct(@PathVariable Long order_id,@PathVariable Long p_id){
        return orderServcice.removeProductFromOrder(order_id,p_id);
    }
    @GetMapping("{order_id}/update/product/{p_id}/amount/{amount}")
    @ResponseBody
    public Order updateAmountOfProducts(@PathVariable Long order_id,@PathVariable Long p_id, @PathVariable Long amount){
        return orderServcice.updateAmountOfProduct (order_id,p_id,amount);

    }






}

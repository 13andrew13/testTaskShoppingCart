package andrew.prog.userCart.controllers;

import andrew.prog.userCart.model.Order;
import andrew.prog.userCart.services.OrderServcice;
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

    @GetMapping("/create")
    @ResponseBody
    public Order createOrder(){
        return orderServcice.createOrder ();
    }

    @GetMapping("{order_id}/produt/{p_id}/amount/{amount}")
    @ResponseBody
    public Order addProduct(@PathVariable Long order_id,@PathVariable Long p_id, @PathVariable Long amount){
        return orderServcice.addProductToOrder (order_id,p_id,amount);
    }






}
